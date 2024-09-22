// ******************************* 계산기 종류 버튼 ******************************
function resultBtn(){
    const resultBox = document.getElementById("result");

    resultBox.innerHTML = "";
}

function weightBtn(){
    const weight = document.getElementById("weight-btn");
    const calory = document.getElementById("calory-btn");
    const feed = document.getElementById("feed-btn");

    weight.style.color = "rgb(170, 188, 221)";
    calory.style.color = "black";
    feed.style.color = "black";

    const weightContent = document.getElementById("weight-content");
    const caloryContent = document.getElementById("calory-content");
    const feedContent = document.getElementById("feed-content");

    weightContent.style.display = 'flex';
    caloryContent.style.display = 'none';
    feedContent.style.display = 'none';

    // if(weightContent.style.display === "none"){
    //     weightContent.style.display = "flex";
    //     caloryContent.style.display = "none";
    //     feedContent.style.display = "none";
    // }

    resultBtn();
}

function caloryBtn(){
    const weight = document.getElementById("weight-btn");
    const calory = document.getElementById("calory-btn");
    const feed = document.getElementById("feed-btn");

    weight.style.color = "black";
    calory.style.color = "rgb(170, 188, 221)";
    feed.style.color = "black";

    const weightContent = document.getElementById("weight-content");
    const caloryContent = document.getElementById("calory-content");
    const feedContent = document.getElementById("feed-content");
    
    // TODO.
    // 1안
    weightContent.style.display = 'none';
    caloryContent.style.display = 'flex';
    feedContent.style.display = 'none';

    // 2안
    // const computedStyle = window.getComputedStyle(caloryContent);    
    // if (computedStyle.display === "none") {
    //     console.log('1111')
    // }

    // JY code
    // if(caloryContent.style.display === "none"){
    //     weightContent.style.display = "none";
    //     caloryContent.style.display = "flex";
    //     feedContent.style.display = "none";
    // }

    resultBtn();
}

function feedBtn(){
    const weight = document.getElementById("weight-btn");
    const calory = document.getElementById("calory-btn");
    const feed = document.getElementById("feed-btn");

    weight.style.color = "black";
    calory.style.color = "black";
    feed.style.color = "rgb(170, 188, 221)";

    const weightContent = document.getElementById("weight-content");
    const caloryContent = document.getElementById("calory-content");
    const feedContent = document.getElementById("feed-content");

    weightContent.style.display = 'none';
    caloryContent.style.display = 'none';
    feedContent.style.display = 'flex';

    // if(feedContent.style.display === "none"){
    //     weightContent.style.display = "none";
    //     caloryContent.style.display = "none";
    //     feedContent.style.display = "flex";
    // }

    resultBtn();
}


// ***************************** Weight 계산기 ***********************************
function calcWeightDogBtn(){
    const dogBtn = document.getElementById("dog-type-weight-btn");
    const catBtn = document.getElementById("cat-type-weight-btn");

    dogBtn.style.backgroundColor = "rgb(191, 206, 236)";
    catBtn.style.backgroundColor = "white";

    const dogTable = document.getElementById("dog-table");
    const catTable = document.getElementById("cat-table");

    dogTable.style.display = "flex";
    catTable.style.display = "none";

    resultBtn()
}

function calcWeightCatBtn(){
    const dogBtn = document.getElementById("dog-type-weight-btn");
    const catBtn = document.getElementById("cat-type-weight-btn");

    dogBtn.style.backgroundColor = "white";
    catBtn.style.backgroundColor = "rgb(191, 206, 236)";

    const dogTable = document.getElementById("dog-table");
    const catTable = document.getElementById("cat-table");

    dogTable.style.display = "none";
    catTable.style.display = "flex";

    resultBtn()
}

function weightCalcBtn(){
    const inputWeight = parseFloat(document.getElementById("now-weight").value);
    const inputBcs = parseInt(document.getElementById("pet-bcs").value);

    // 표준체중 : 강아지 표준체중 = 현재 몸무게 x 100 / {100+ 10(BCS-5)}
    // 표준체중 : 고양이 표준체중 = 현재 몸무게 x 100 / {100+ 5(BCS-5)}

    // 내 강아지 몸무게(inputWeight)가 표준체중(regularWeight)보다 크면 비만
    //                                         낮으면 저체중
    // (+- 5% : 정상) (+6~14% : 과체중) (+15%  비만)

    // 표준 체중에서 ±10% 범위에 해당하는 체중은 정상으로 간주됩니다.
    // 과체중: 10% ~ 20% 초과

    // 표준 체중보다 10%에서 20%까지 높은 경우 과체중으로 분류됩니다.
    // 비만: 20% 초과

    // 표준 체중보다 20% 이상 초과하면 비만으로 판단됩니다.
    // 권장 칼로리 : 종류(강, 고), 성별, 몸무게, 


    const regularDogWeight = inputWeight * 100 / (100 + 10 * (inputBcs - 5));
    const regularCatWeight = inputWeight * 100 / (100 + 5 * (inputBcs - 5));

    const dogBtn = document.getElementById("dog-type-weight-btn");
    const catBtn = document.getElementById("cat-type-weight-btn");

    const result = document.getElementById("result");

    const computedDogStyle = window.getComputedStyle(dogBtn);
    const computedCatStyle = window.getComputedStyle(catBtn);


    if(computedDogStyle.backgroundColor === "rgb(191, 206, 236)"){
        result.innerHTML = `고객님의 강아지 체중은 "${inputWeight}(kg)"으로 표준체중은 "${(regularDogWeight).toFixed(2)}(kg)" 입니다.<br>
                            정상 체중은 "${(regularDogWeight * 0.95).toFixed(2)}(kg) <= 정상 < ${(regularDogWeight * 1.05).toFixed(2)}(kg)" 이며,<br>`;
        if(inputWeight < regularDogWeight * 0.95){
            result.innerHTML += `고객님의 강아지는 "${inputWeight}(kg) < ${(regularDogWeight * 0.95).toFixed(2)}(kg)"에 속하므로 "저체중"에 해당합니다.`;
        } else if(inputWeight < regularDogWeight * 1.05) {
            result.innerHTML += `고객님의 강아지는 "${(regularDogWeight * 0.95).toFixed(2)}(kg) < ${inputWeight}(kg) <= ${(regularDogWeight * 1.05).toFixed(2)}(kg)"에 속하므로 "정상체중"에 해당합니다.`;
        } else if(inputWeight < regularDogWeight * 1.15) {
            result.innerHTML += `고객님의 강아지는 "${(regularDogWeight * 1.05).toFixed(2)}(kg) < ${inputWeight}(kg) <= ${(regularDogWeight * 1.15).toFixed(2)}(kg)"에 속하므로 "과체중"에 해당합니다.`;
        } else {
            result.innerHTML += `고객님의 강아지는 "${(regularDogWeight * 1.15).toFixed(2)}(kg) < ${inputWeight}(kg)"에 속하므로 "비만"에 해당합니다.`;
        }
    } else if(computedCatStyle.backgroundColor === "rgb(191, 206, 236)") {
        result.innerHTML = `고객님의 고양이 체중은 "${inputWeight}(kg)"으로 표준체중은 "${(regularCatWeight).toFixed(2)}(kg)"입니다.<br>
                            정상 체중은 "${(regularCatWeight * 0.9).toFixed(2)}(kg) <= 정상 < ${(regularCatWeight * 1.1).toFixed(2)}(kg)" 이며,<br>`;
        if(inputWeight < regularDogWeight * 0.9){
            result.innerHTML += `고객님의 고양이는 "${inputWeight}(kg) < ${(regularCatWeight * 0.9).toFixed(2)}(kg)"에 속하므로 "저체중"에 해당합니다.`;
        } else if(inputWeight < regularDogWeight * 1.1) {
            result.innerHTML += `고객님의 고양이는 "${(regularCatWeight * 0.9).toFixed(2)}(kg) < ${inputWeight}(kg) <= ${(regularCatWeight * 1.1).toFixed(2)}(kg)"에 속하므로 "정상체중"에 해당합니다.`;
        } else if(inputWeight < regularDogWeight * 1.2) {
            result.innerHTML += `고객님의 고양이는 "${(regularCatWeight * 1.1).toFixed(2)}(kg) < ${inputWeight}(kg) <= ${(regularCatWeight * 1.2).toFixed(2)}(kg)"에 속하므로 "과체중"에 해당합니다.`;
        } else {
            result.innerHTML += `고객님의 고양이는 "${(regularCatWeight * 1.2).toFixed(2)}(kg) < ${inputWeight}(kg)"에 속하므로 "비만"에 해당합니다.`;
        }
    } else {
        result.innerHTML = `애완동물의 종류를 선택해주세요`;
    }
}



// ***************************** Calory 계산기 ***********************************
function calcCaloryDogBtn(){
    const dogBtn = document.getElementById("dog-type-calory-btn");
    const catBtn = document.getElementById("cat-type-calory-btn");

    dogBtn.style.backgroundColor = "rgb(191, 206, 236)";
    catBtn.style.backgroundColor = "white";

    const dogContent = document.getElementById("left-dog-content");
    const catContent = document.getElementById("left-cat-content");

    dogContent.style.display = "flex";
    catContent.style.display = "none";

    resultBtn()
}

function calcCaloryCatBtn(){
    const dogBtn = document.getElementById("dog-type-calory-btn");
    const catBtn = document.getElementById("cat-type-calory-btn");

    dogBtn.style.backgroundColor = "white";
    catBtn.style.backgroundColor = "rgb(191, 206, 236)";

    const dogContent = document.getElementById("left-dog-content");
    const catContent = document.getElementById("left-cat-content");

    dogContent.style.display = "none";
    catContent.style.display = "flex";

    resultBtn()
}

function caloryCalcBtn(){
    const inputWeight = parseFloat(document.getElementById("calory-weight").value);
    const inputFigure = parseFloat(document.getElementById("figure").value);

    // 하루 권장 칼로리 = 상황에 따른 수치 x ( (30 x 체중(kg)) + 70 )
    const dayCalory = inputFigure * ((30 * inputWeight) + 70);

    const dogBtn = document.getElementById("dog-type-calory-btn");
    const catBtn = document.getElementById("cat-type-calory-btn");

    const result = document.getElementById("result");

    const computedDogStyle = window.getComputedStyle(dogBtn);
    const computedCatStyle = window.getComputedStyle(catBtn);


    if(computedDogStyle.backgroundColor === "rgb(191, 206, 236)"){
        result.innerHTML = `고객님의 강아지 권장 칼로리량은 약 "${dayCalory}(kcal)" 입니다.`;
    } else if(computedCatStyle.backgroundColor === "rgb(191, 206, 236)"){
        result.innerHTML = `고객님의 고양이 권장 칼로리량은 약 "${dayCalory}(kcal)" 입니다.`;
    } else {
        result.innerHTML = `애완동물의 종류를 선택해주세요`;
    }
}


// ***************************** Feed 계산기 ***********************************
function calcFeedDogBtn(){
    const dogBtn = document.getElementById("dog-type-feed-btn");
    const catBtn = document.getElementById("cat-type-feed-btn");

    dogBtn.style.backgroundColor = "rgb(191, 206, 236)";
    catBtn.style.backgroundColor = "white";

    const dogContent = document.getElementById("dog2-img");
    const catContent = document.getElementById("cat2-img");

    dogContent.style.display = "flex";
    catContent.style.display = "none";

    resultBtn()
}

function calcFeedCatBtn(){
    const dogBtn = document.getElementById("dog-type-feed-btn");
    const catBtn = document.getElementById("cat-type-feed-btn");

    dogBtn.style.backgroundColor = "white";
    catBtn.style.backgroundColor = "rgb(191, 206, 236)";

    const dogContent = document.getElementById("dog2-img");
    const catContent = document.getElementById("cat2-img");

    dogContent.style.display = "none";
    catContent.style.display = "flex";

    resultBtn()
}

function feedCalcBtn(){
    const inputDayCalory = parseInt(document.getElementById("pet-day-calory").value);
    const inputFeedCalory = parseInt(document.getElementById("feed-day-calory").value);

    const FeedAmount = (inputDayCalory * 1000) / inputFeedCalory;

    const dogBtn = document.getElementById("dog-type-feed-btn");
    const catBtn = document.getElementById("cat-type-feed-btn");

    const result = document.getElementById("result");

    const computedDogStyle = window.getComputedStyle(dogBtn);
    const computedCatStyle = window.getComputedStyle(catBtn);


    if(computedDogStyle.backgroundColor === "rgb(191, 206, 236)"){
        result.innerHTML = `고객님의 강아지 권장 사료량은 약 "${FeedAmount.toFixed(2)}(g)" 입니다.`;
    } else if(computedCatStyle.backgroundColor === "rgb(191, 206, 236)"){
        result.innerHTML = `고객님의 고양이 권장 사료량은 약 "${FeedAmount.toFixed(2)}(g)" 입니다.`;
    } else {
        result.innerHTML = `애완동물의 종류를 선택해주세요`;
    }
}