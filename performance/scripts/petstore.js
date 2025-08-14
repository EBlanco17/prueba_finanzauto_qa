import http from "k6/http";
import { check, sleep } from "k6";
import { Trend, Rate } from "k6/metrics";

// --- MÉTRICAS PERSONALIZADAS ---
let responseTime = new Trend("response_time");
let errorRate = new Rate("errors");

export let options = {
  vus: 20, // usuarios virtuales simultáneos
  duration: "1m", // duración total del test
  thresholds: {
    errors: ["rate<0.05"], // máximo 5% de errores
    http_req_duration: ["p(95)<1000"], // 95% de requests < 1s
  },
};

const BASE_URL = "https://petstore.swagger.io/v2";
const API_KEY = "special-key";

// FUNCIONES AUXILIARES
function recordMetrics(res) {
  responseTime.add(res.timings.duration);
  if (!check(res, { "status 200": (r) => r.status === 200 })) {
    errorRate.add(1);
  } else {
    errorRate.add(0);
  }
  sleep(1);
}

// --- SCRIPT PRINCIPAL ---
export default function () {
  // 1. GET - listar mascotas por estado
  let resFind = http.get(`${BASE_URL}/pet/findByStatus?status=available`, {
    headers: { api_key: API_KEY },
  });
  recordMetrics(resFind);

  // 2. POST - crear una nueva mascota
  let payload = JSON.stringify({
    id: Math.floor(Math.random() * 100000),
    name: `TestPet-${Math.floor(Math.random() * 1000)}`,
    status: "available",
  });

  let resPost = http.post(`${BASE_URL}/pet`, payload, {
    headers: {
      "Content-Type": "application/json",
      api_key: API_KEY,
    },
  });
  recordMetrics(resPost);

  // 3. PUT - actualizar la mascota
  let updatePayload = JSON.stringify({
    id: JSON.parse(payload).id,
    name: `UpdatedPet-${Math.floor(Math.random() * 1000)}`,
    status: "sold",
  });

  let resPut = http.put(`${BASE_URL}/pet`, updatePayload, {
    headers: {
      "Content-Type": "application/json",
      api_key: API_KEY,
    },
  });
  recordMetrics(resPut);

  // 4. POST upload image
  let formData = {
    file: http.file(open("./resources/files/pet.jpg", "b"), "pet.jpg"),
  };
  let resUpload = http.post(
    `${BASE_URL}/pet/${JSON.parse(payload).id}/uploadImage`,
    formData,
    {
      headers: { api_key: API_KEY },
    }
  );
  recordMetrics(resUpload);

  // 5. GET - obtener la mascota creada
  let resGet = http.get(`${BASE_URL}/pet/${JSON.parse(payload).id}`, {
    headers: { api_key: API_KEY },
  });
  recordMetrics(resGet);
}

// This will export to HTML as filename "petstore.html" AND also stdout using the text summary
import { htmlReport } from "https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js";
import { textSummary } from "https://jslib.k6.io/k6-summary/0.0.1/index.js";

export function handleSummary(data) {
  return {
    "results/sites/petstore.html": htmlReport(data, {
      title: "Petstore API Performance",
    }),
    stdout: textSummary(data, {
      indent: " ",
      enableColors: true,
    }),
  };
}
