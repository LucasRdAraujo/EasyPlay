const messageForm = document.querySelector('#messageForm'),
    messageInput = document.querySelector('#message-input'),
    messagesList = document.querySelector("#chat-messages");

var userLoggedIn, stomp;
var menu = false;

function createServer() {
    let elem = document.querySelector("#serverCreateOverlay");
    menu = !menu;
    if (menu)
        elem.style.display = "none";
    else
        elem.style.display = "flex";
} createServer();

function connect() {
    userLoggedIn = JSON.parse(localStorage.getItem('userLoggedIn'));

    if (userLoggedIn) {
        let socket = new SockJS('/ws');
        stomp = Stomp.over(socket);

        stomp.connect({}, onConnected, onError);
    }
}

function sendMessage(event) {
    let mt = messageInput.value.trim();
    if (mt) {
        stomp.send(`/channels/${userLoggedIn.currentAction.channel}/message`, {}, JSON.stringify({
            id: new Date().getTime(),
            senderid: userLoggedIn.id,
            content: messageInput.value
        }));
    }
    messageInput.value = '';
    event.preventDefault();
}

function onConnected() {
    stomp.subscribe(`/topic/channels/${userLoggedIn.currentAction.channel}/message`, onMessage);
}

function onMessage(payload) {
    let message = JSON.parse(payload.body);
    let messageElem = document.createElement("div");
    messageElem.id = `${message.id}`;
    messageElem.setAttribute("class", "message min-h-message group-start message-wapper-p-left message-wrapper");
    messageElem.innerHTML = `
        <div class="message-content">
            <img src="../../assets/imgs/photo.png"
                class="avatar" alt="">
            <h2 class="message-header">${message.sender}</h2>
            <div class="markup message-content">${message.content}</div>
        </div>
    `;
    messagesList.appendChild(messageElem);
}

function onError(err) {
    console.log(err);
}

connect();
messageForm.addEventListener('submit', sendMessage, true);