document.addEventListener("DOMContentLoaded", function () {
  const regForm = document.getElementById("regForm");
  const editForm = document.getElementById("editForm");
  const listDiv = document.getElementById("list");
  let members = [];

  // localstorage에 저장
  if (localStorage.getItem("members")) {
    members = JSON.parse(localStorage.getItem("members"));
    displayMembers();
  }

  // 회원 정보 저장
  regForm.addEventListener("submit", function (event) {
    event.preventDefault();
    const uid = document.getElementById("uid").value;
    const pw = document.getElementById("pw").value;
    const uname = document.getElementById("uname").value;

    // 배열 생성
    members.push({
      id: uid,
      password: pw,
      name: uname,
    });

    // localstorage에 저장
    localStorage.setItem("members", JSON.stringify(members));

    // 회원 리스트 update
    displayMembers();

    // reset
    regForm.reset();
  });

  // 회원 리스트 출력
  function displayMembers() {
    listDiv.innerHTML = "";
    const table = document.createElement("table");
    table.classList.add("listtable");

    // header 생성
    const headerRow = table.insertRow();
    const headers = ["index", "ID", "이름", "관리"];
    headers.forEach((headerText) => {
      const th = document.createElement("th");
      th.textContent = headerText;
      headerRow.appendChild(th);
    });

    // 배열 생성
    members.forEach(function (member, index) {
      const row = table.insertRow();
      row.insertCell().textContent = index + 1;
      row.insertCell().textContent = member.id;
      row.insertCell().textContent = member.name;

      // 수정/삭제 버튼
      const manageCell = row.insertCell();
      const editButton = document.createElement("button");
      editButton.textContent = "수정";
      editButton.addEventListener("click", function () {
        editMember(index);
      });
      manageCell.appendChild(editButton);

      const deleteButton = document.createElement("button");
      deleteButton.textContent = "삭제";
      deleteButton.addEventListener("click", function () {
        deleteMember(index);
      });
      manageCell.appendChild(deleteButton);
    });

    // 회원 리스트에 추가
    listDiv.appendChild(table);
  }

  // 회원 수정
  function editMember(index) {
    const selectedMember = members[index];
    document.getElementById("eid").value = selectedMember.id;
    document.getElementById("epw").value = selectedMember.password;
    document.getElementById("ename").value = selectedMember.name;
    document.getElementById("idx").value = index;
    document.getElementById("edit").style.display = "block";
  }

  // 회원 수정 event
  editForm.addEventListener("submit", function (event) {
    event.preventDefault();
    const idx = document.getElementById("idx").value;
    const eid = document.getElementById("eid").value;
    const epw = document.getElementById("epw").value;
    const ename = document.getElementById("ename").value;

    // 수정한 내용 update
    members[idx].id = eid;
    members[idx].password = epw;
    members[idx].name = ename;

    // localstorage에 저장
    localStorage.setItem("members", JSON.stringify(members));

    // 회원 리스트 update
    displayMembers();

    // reset
    editForm.reset();

    // 숨김처리
    document.getElementById("edit").style.display = "none";
    document.getElementById("reg").style.display = "block";
  });

  // 삭제하기
  function deleteMember(index) {
    members.splice(index, 1);

    localStorage.setItem("members", JSON.stringify(members));

    displayMembers();
  }
});
