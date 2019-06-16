function solve() {
   const btn = document.querySelector('button');
   btn.addEventListener('click', function (evt) {
      let message = document.querySelector('#chat_input').value;
      if (message) {
         const myMessage = document.createElement('div');
         myMessage.textContent = message;
         myMessage.setAttribute('class', 'message my-message');
         document.querySelector('#chat_messages').appendChild(myMessage);
          
      }
      document.querySelector('#chat_input').value = '';
   });
}


