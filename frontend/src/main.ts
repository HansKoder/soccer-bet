const apiUrl = "http://localhost:8080/api/v1/match"; // Ajusta tu endpoint

const getBtn = document.getElementById("getBtn") as HTMLButtonElement;
const postBtn = document.getElementById("postBtn") as HTMLButtonElement;
const responseBox = document.getElementById("response") as HTMLPreElement;

const user = "User";
const pass = "4611f44a-1e98-4e4d-b3fd-b212e3b377d1";
const auth = "Basic " + btoa(user + ":" + pass);

getBtn.addEventListener("click", async () => {
  try {
    const url = `${apiUrl}/987af314-630a-4325-a157-61f54d5f04a5`;
    const res = await fetch(url , {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        "Authorization": auth
      }
    });
    const data = await res.text();
    responseBox.textContent = data;
  } catch (err) {
    responseBox.textContent = `Error: ${err}`;
  }
});

postBtn.addEventListener("click", async () => {
  try {
    const url = `${apiUrl}/schedule`;
    const res = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Authorization": auth
      },
      body: JSON.stringify({ local: "Colombia", visiting: "Peru", tournament: "Mundial 2026" })
    });
    const data = await res.json();
    responseBox.textContent = JSON.stringify(data, null, 2);
  } catch (err) {
    responseBox.textContent = `Error: ${err}`;
  }
});