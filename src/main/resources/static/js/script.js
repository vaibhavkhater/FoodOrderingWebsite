const navbar = document.querySelector('#navBar');
const content = document.querySelector('#content-id');
console.log("hello");
const t = navbar.offsetTop;

function stickynavbar() {
    if (window.scrollY >= t) {
        navbar.classList.add('sticky');
        content.classList.add('content-class');
    } else {
        navbar.classList.remove('sticky');
        content.classList.remove('content-class');
    }
}
window.addEventListener('scroll', stickynavbar);