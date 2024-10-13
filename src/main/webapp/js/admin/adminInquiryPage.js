function answerInquiry(inquiryNo) {
    let modalHeadEL = document.querySelector(".modal-title");
    let modalBodyEL = document.querySelector(".modal-body");

    $.ajax({
        url: "selectInquiry.in",
        data: {
            inquiryNo: inquiryNo
        },
        success: function (inquiryInfo) {
            let str = "";

            str += "<input type='number' name='inquiryNo' value='" + inquiryNo + "' class='hide'>";

            str += "<div class=\"input-group input-group-sm mb-3 \">\n" +
                "    <span class=\"input-group-text\">문의 제목</span>\n" +
                "    <span class=\"form-control\">" + inquiryInfo.inquiryTitle + "</span>\n" +
                "</div>";

            str += "<div class=\"input-group input-group-sm mb-3 \">\n" +
                "    <span class=\"input-group-text\">문의 내용</span>\n" +
                "    <span class=\"form-control\">" + inquiryInfo.inquiryDetail + "</span>\n" +
                "</div>";

            str += "<div class=\"input-group input-group-sm mb-3\">\n" +
                "    <span class=\"input-group-text\">문의 답변</span>\n" +
                "    <textarea name=\"answer\" id=\"\" cols=\"47\" rows=\"5\"></textarea>\n" +
                "</div>";

            modalBodyEL.innerHTML = str;
        },
        error: function () {
            console.log("문의 내용 AJAX 요청 실패");
        }
    });
}
