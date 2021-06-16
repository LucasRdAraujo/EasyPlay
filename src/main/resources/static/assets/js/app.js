const messageForm = document.querySelector('#messageForm'),
    messageInput = document.querySelector('#message-input'),
    messagesList = document.querySelector("#chat-messages");

var user;
var stomp;

let menu = false;

function createServer() {
    let elem = document.querySelector("#serverCreateOverlay");
    menu = !menu;
    if (menu)
        elem.style.display = "none";
    else
        elem.style.display = "flex";
} createServer();

function connect() {
    user = JSON.parse(localStorage.getItem('user'));

    if (user) {
        let socket = new SockJS('/ws');
        stomp = Stomp.over(socket);

        stomp.connect({}, onConnected, onError);
    }
}

function sendMessage(event) {
    let mt = messageInput.value.trim();
    if (mt) {
        stomp.send(`/channels/${localStorage.getItem('currentChannel')}`, {}, JSON.stringify({
            id: new Date().getTime(),
            ch_id: localStorage.getItem('currentChannel'),
            sender: user.id,
            content: messageInput.value
        }));
    }
    messageInput.value = '';
    event.preventDefault();
}

function onConnected() {
    stomp.subscribe(`/topic/channels/${localStorage.getItem('currentChannel')}`, onMessage);
}

function onMessage(payload) {
    let message = JSON.parse(payload.body);
    let messageElem = document.createElement("div");
    messageElem.id= `${message.id}`;
    messageElem.setAttribute("class", "message min-h-message group-start message-wapper-p-left message-wrapper");
    messageElem.innerHTML = `
        <div class="message-content">
            <img src="./assets/imgs/photo.png"
                class="avatar" alt="">
            <h2 class="message-header">${message.sender}</h2>
            <div class="markup message-content">${message.content}</div>
        </div>
    `;
    messagesList.appendChild(messageElem);
    console.log(payload, message);
}

function onError(err) {
    console.log(err);
}

connect();
messageForm.addEventListener('submit', sendMessage, true);