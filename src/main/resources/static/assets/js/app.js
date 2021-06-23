var menu = false;

function createServer() {
    let elem = document.querySelector("#serverCreateOverlay");
    menu = !menu;
    if (menu)
        elem.style.display = "none";
    else
        elem.style.display = "flex";
} createServer();