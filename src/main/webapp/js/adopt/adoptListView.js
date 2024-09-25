function adoptMissingBtn(){
    const missingBtn = document.getElementById("missing-btn");
    const distributeBtn = document.getElementById("distribute-btn");

    missingBtn.style.color = "rgb(152, 184, 219)";
    distributeBtn.style.color = "black";

    const missingTable = document.getElementById("missing-pet-table");
    const distributeTable = document.getElementById("distribute-pet-table")

    missingTable.style.display = "table";
    distributeTable.style.display = "none";
}

function adoptDistributeBtn(){
    const missingBtn = document.getElementById("missing-btn");
    const distributeBtn = document.getElementById("distribute-btn");

    missingBtn.style.color = "black";
    distributeBtn.style.color = "rgb(152, 184, 219)";

    const missingTable = document.getElementById("missing-pet-table");
    const distributeTable = document.getElementById("distribute-pet-table")

    missingTable.style.display = "none";
    distributeTable.style.display = "table";
}