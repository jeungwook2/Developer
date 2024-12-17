const fileArea = document.querySelector("#file-area");

document.addEventListener("dragover", function (e) {
  e.preventDefault();
});

document.addEventListener("drop", function (e) {
  e.preventDefault();
});

const dropArea = document.querySelector("#drop-area");

dropArea.addEventListener("dragover", function (e) {
  e.preventDefault();
});

dropArea.addEventListener("dragenter", function (e) {
  e.target.classList.add("bg-gray");
});

dropArea.addEventListener("dragleave", function (e) {
  e.target.classList.remove("bg-gray");
});

dropArea.addEventListener("drop", function (e) {
  e.preventDefault();
  e.target.classList.remove("bg-gray");
  console.log(e.dataTransfer.files);

  for (const f of e.dataTransfer.files) {
    const imgElem = document.createElement("img");
    const fr = new FileReader();
    fr.onload = function (e) {
      const dataUrl = e.target.result;
      imgElem.setAttribute("src", dataUrl);
      imgElem.setAttribute("width", '200');
      imgElem.setAttribute("height", '200');
    }
    fr.readAsDataURL(f);

    fileArea.appendChild(imgElem);
  }

});
