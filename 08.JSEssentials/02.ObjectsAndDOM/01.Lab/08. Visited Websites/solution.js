function solve() {
    const links = document.querySelectorAll('a');
    [...links].forEach(link => link.addEventListener('click', function(evt) {
      const p = evt.currentTarget.nextElementSibling;
      const visitedCount = +(p.textContent).match(/\d+/)[0] + 1;
      p.textContent = `Visited: ${visitedCount} times`;
    }));
}