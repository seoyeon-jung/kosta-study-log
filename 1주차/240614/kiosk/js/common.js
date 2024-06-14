const modal = document.querySelector('.modal');
const modalOpen = document.querySelectorAll('.modal_btn');

//열기 버튼을 눌렀을 때 모달팝업이 열림
modalOpen.forEach(function(btn) {
    btn.addEventListener('click', function() {
        modal.style.display = 'block'; // 해당 모달을 보이도록 함
    });
});