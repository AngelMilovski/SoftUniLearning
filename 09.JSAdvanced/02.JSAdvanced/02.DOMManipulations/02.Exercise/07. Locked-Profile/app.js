function lockedProfile() {
    [...document.getElementsByTagName('button')].forEach(b => b.addEventListener('click', showMore));
 
    function showMore(evt) {
       let btn = evt.target;
       let userProfileIsLock = evt.target.parentNode.children[2].checked === true;
       if (!userProfileIsLock) {
          evt.target.parentNode.children[9].style.display = 'inline-block';
          btn.textContent = 'Hide it';
          btn.removeEventListener(evt.type, showMore);
          btn.addEventListener('click', hideIt);
       }
    }
 
    function hideIt(evt) {
       let userProfileIsLock = evt.target.parentNode.children[2].checked === true;
       if (!userProfileIsLock) {
          evt.target.parentNode.children[9].style.display = 'none';
          evt.target.textContent = 'Show more';
          evt.target.removeEventListener(evt.type, hideIt);
          evt.target.addEventListener('click', showMore);
       }
    }
 } 