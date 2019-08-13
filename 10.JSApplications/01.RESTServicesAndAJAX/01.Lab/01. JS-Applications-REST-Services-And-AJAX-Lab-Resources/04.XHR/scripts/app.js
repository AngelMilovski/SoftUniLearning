function loadRepos() {
   const result = document.querySelector('#res');
   
   const statusChecker = {
      isSuccess: (status) => status == 200,
   };
   
   const handleResponse = function() {
      if (req.readyState == 4 && statusChecker.isSuccess(req.status)) {
         result.innerHTML = req.responseText;
      }
   };
   
   const req = new XMLHttpRequest();
   req.onreadystatechange = handleResponse;
   const method = 'GET';
   const url = 'https://api.github.com/users/testnakov/repos';
   const async = true;
   req.open(method, url, async);
   req.send();
}