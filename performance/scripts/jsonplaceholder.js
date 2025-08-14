import http from "k6/http";
import { check } from "k6";
import { Rate } from "k6/metrics";

export let errorRate = new Rate("errors");

export let options = {
  vus: 100, // 100 usuarios concurrentes
  duration: "2m", // 2 minutos
  //   thresholds: {
  //     errors: ['rate<0.20'],           // aceptar hasta 20% de errores
  //     http_req_duration: ['p(95)<60000'] // p95 < 60s
  // }
  thresholds: {
    errors: ["rate<0.05"],
    http_req_duration: ["p(95)<500"], // p95 < 500ms
  },
};

export default function () {
  let res = http.get("https://jsonplaceholder.typicode.com/posts");
  check(res, { "status 200": (r) => r.status === 200 }) || errorRate.add(1);
}

// This will export to HTML as filename "jsonplaceholder.html" AND also stdout using the text summary
import { htmlReport } from "https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js";
import { textSummary } from "https://jslib.k6.io/k6-summary/0.0.1/index.js";

export function handleSummary(data) {
  return {
    "results/sites/jsonplaceholder.html": htmlReport(data, {
      title: "JsonPlaceHolder API Performance",
    }),
    stdout: textSummary(data, {
      indent: " ",
      enableColors: true,
    }),
  };
}
