/* clickButton.js */

/* 切換會員專區頁面按鈕JavaScript */

function clickButton(evt, buttonName) {
    // Declare all variables
    // 設定變數
    var i, button, content;

    // Get all elements with class="tabcontent" and hide them
    // 取得主要內容頁面
    content = document.getElementsByClassName("member_content");
    for (i = 0; i < content.length; i++) {
        content[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    // 按下按鈕變化主要頁面內容及按鈕樣式(css中的 .member_menu_button.active)
    button = document.getElementsByClassName("member_menu_button");
    for (i = 0; i < button.length; i++) {
        button[i].className = button[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the link that opened the tab
    document.getElementById(buttonName).style.display = "block";
    evt.currentTarget.className += " active";
}