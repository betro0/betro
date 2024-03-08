<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Alexandria:wght@100..900&display=swap');
</style>
  <title>إضافة وعرض وتعديل وحذف اهداف المؤتمر</title>
  <style>
    #body{
       direction: rtl;
       font-family: "Alexandria", sans-serif;
    font-optical-sizing: auto;
    font-weight: 100;
    font-style: normal;
    }
    .popup {
      display: none;
      position: fixed;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      padding: 40px;
      width: 350px;
    height: 250px;
      border: 1px solid #0091b9;
      border-radius: 30px;
      box-shadow: 0px 0px 15px 0px #0091b9;
      background-color: #fff;
      z-index: 1;
      overflow-y: auto; /* إضافة التمرير العمودي */
      max-height: 50vh; /* ارتفاع أقصى للنافذة */
      max-width: 100vh;
           
    }
    .popup_delet{
      display: none;
      position: fixed;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      padding: 40px;
      width: 350px;
    height: 80px;
    border-radius: 30px;
      border: 1px solid #0091b9;
      box-shadow: 0px 0px 15px 0px #0091b9;
      background-color: #fff;
    }

    .close {
      position: absolute;
      top: 10px;
      right: 15px;
      font-size: 20px;
      font-weight: bold;
      cursor: pointer;
    }

    #showImage {
      max-width: 100%;
      height: auto;
      margin-top: 10px;
    }

    #add, #show, #edit, #delet {
      display: none;
    }

    .goal-indicator {
      display: inline-block;
      width: 50px;
      margin-right: 10px;
    }

    .goal-slider {
      width: 200px;
      margin-top: 5px;
    }
    textarea{
      width: 100%;
    height: 70%;
    outline: none;
    border: none;
    background: #deecf0;
    margin: 6px 0;
    border-radius: 6px;
    padding: 5px;
    }
textarea:focus{
  background: #bde5f0;
    transform: scale(1.05);
}
button{
  position: absolute;
    width: 20%;
    height: 40px;
    border: none ;
    cursor: pointer;
    font-size: medium;
    background: #0091b9;
    color: rgb(255, 255, 255);
    border-radius: 30px;
    transition: 0.5s;
    margin: 0px;
}
button:hover{
    background: #17c1f0;
    letter-spacing: 2px;
    
}
.select_style{
  width: 50%;
}
.button1{
  left: 77%;
}
.button2{
  left: 52%;
}
.button3{
  left: 27%
}
.button4{
  left: 2%;
}

.ul_show{
  top: 30%;
 /*   position: absolute;*/
     word-wrap: break-word; 

}
h1{
  background: #0091b9;
  color: white;
    border-radius: 20px;
    padding: 10px;
    position: absolute;
    top: 18%;
    right: 40%;
}
/* تلوين مؤشر الـ range في جميع المتصفحات */
input[type="range"] {
    -webkit-appearance: none;
    appearance: none;
    height: 10px;
    border-radius: 5px;
    background: #b8ccd1; /* لون خلفية المؤشر */
    outline: none;
    margin: 10px 0;
}

input[type="range"]::-webkit-slider-thumb {
    -webkit-appearance: none;
    appearance: none;
    width: 20px;
    height: 20px;
    border-radius: 50%;
    background: #0091b9 /* لون مؤشر الـ range */
  
}

.button_style {
    margin: 10px 0px 0px 0px;
      background-color: #cdcdcd;
    padding: 25px;
    height: 40px;
    border: none;
    border-radius: 20px
    }
.button_submit{
  width: 80%;
    top: auto;
    margin: 10px;
}


   /*.popup_show{
    background-color: #cdcdcd;
    padding: 25px;
    height: 2000px;
    border: none;
    border-radius: 20px;
    margin: 10px 0px 0px 0px
  
   }*/
   .div_style{
          background:#cdcdcd ;
            border-radius: 20px;
            margin: 20px 5px 5px 5px;
            padding: 50px 25px 50px 0px;
            min-height: 300px; /* ارتفاع ابتدائي */

        }

  </style>
</head>
<body id="body">
<?php
$servername ="localhost";
$username="betro";
$password="12345678";
$dbname="team2_net2_2023";
$conn = mysqli_connect($servername ,$username ,$password ,$dbname);
 if($conn->connect_error){
    die("error".$conn->connect_error);
  } 
  if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['action']) && $_POST['action'] == 'addgoal') {
    $goal = $conn->real_escape_string($_POST["goal"]);
    $sql = "INSERT INTO conference_objectives (conference_objectives) VALUES ('$goal')";
    if ($conn->query($sql) === TRUE) {
        echo '<script>alert("Your message goes here");</script>';
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }
  }if(isset($_POST['show']) && $_POST['show'] == 'showgoal')
  {
     // تنفيذ استعلام SQL لاسترجاع البيانات
     $result = mysqli_query($conn, "SELECT * FROM conference_objectives");
      // عرض البيانات بالطريقة التي تريدها
      while ($row = mysqli_fetch_assoc($result)) {
      echo '<ol class="ul_show"> <li>  ' . $row['conference_objectives'] . ' </li></ol></br>'
      ;
    }
  }
    

$conn->close();

?>

<div class="button_style">
<!-- الأزرار -->
<button onclick="openAddPopup()" id="add" class="button1">إضافة اهدف المؤتمر</button>
<form action="" method="post" >
<button onclick="openShowPopup()" id="show" class="button2" name="show" value="showgoal" >عرض اهداف المؤتمر</button>
</form>
<button onclick="openEditPopup()" id="edit" class="button3"> تعديل اهداف المؤتمر</button>
<button onclick="openDeletePopup()" id="delet" class="button4">حذف اهداف المؤتمر</button>
</div>

<form action="" method="post" >
<!-- نافذة إضافة اهداف المؤتمر-->
<div id="addPopup" class="popup">
  <span class="close" onclick="closePopup('addPopup')">&times;</span>
  <label for="infoTextarea">اهداف المؤتمر:</label>
  <textarea id="infoTextarea" placeholder="ادخل اهداف المؤتمر:" name="goal"></textarea>
  <br>
  <button onclick="saveUserInfo()" class="button_submit" name="action" value="addgoal" >حفظ</button>
</div>
</form>


<div class="div_style">
<h1>أهداف المؤتمر</h1>
<!-- نافذة عرض اهداف المؤتمر-->
<div id="showPopup" class="popup_show">
  <span class="close" onclick="closePopup('showPopup')"></span>
  <ol id="showContent" class="ul_show"></ol>
</div>
</div>
<div id="h"></div>


<form action="">
<!-- نافذة تعديل اهداف المؤتمر-->
<div id="editPopup" class="popup">
  <span class="close" onclick="closePopup('editPopup')">&times;</span>
  <label for="selectPerson">اختر الهدف:</label>
  <select id="selectPerson" class="select_style" onchange="loadPersonData()"></select>
  <br>
  <label for="editInfoTextarea">اهداف المؤتمر:</label>
  <textarea id="editInfoTextarea" placeholder="ادخل محاور المؤتمر:"></textarea>
  <div>
    <label for="progressSlider">نسبة الإنجاز من الهدف:</label>
    <input type="range" class="goal-slider" id="progressSlider" value="0" onchange="updateVolumeIndicator()" />
    <div class="goal-indicator" id="volumeIndicator">0%</div>
  </div>
  <br>
  <button onclick="saveEditedUserInfo()" class="button_submit">حفظ التعديل</button>
</div>
</form>

<form action="">
<!-- نافذة حذف اهداف المؤتمر-->
<div id="deletePopup" class="popup_delet">
  <span class="close" onclick="closePopup('deletePopup')">&times;</span>
  <label for="deletePerson">اختر الهدف المراد حدف:</label>
  <select id="deletePerson" class="select_style"></select>
  <br>
  <button onclick="confirmDelete()" class="button_submit">تأكيد الحذف</button>
</div>
</form>
<script>
  var userInformation = [];
  var userRole = "admin"; // يمكن تحديده من قاعدة البيانات

  // فحص صلاحيات المستخدم
  if (userRole === "admin") {
    document.getElementById('add').style.display = 'block';
    document.getElementById('show').style.display = 'block';
    document.getElementById('edit').style.display = 'block';
    document.getElementById('delet').style.display = 'block';
  } else {
    document.getElementById('show').style.display = 'block';
  }

  // فتح نافذة إضافة اهداف المؤتمر
  function openAddPopup() {
    document.getElementById('addPopup').style.display = 'block';
  }

  // عرض الاهداف في نافذة منفصلة مع المؤشر
  function openShowPopup() {
    var displayText = "";
    for (var i = 0; i < userInformation.length; i++) {
      displayText += "<li>الهدف: " + userInformation[i].info +
        '<br>' +
        '<label for="displayProgressSlider' + i + '">نسبة الإنجاز:</label>' +
        '<input type="range" id="displayProgressSlider' + i + '" value="' + (userInformation[i].progress || 0) + '" disabled />' +
        '<div class="goal-indicator" id="displayVolumeIndicator' + i + '"> ' + (userInformation[i].progress || 0) + '%</div>' +
        "</li>";
    }

    if (displayText !== "") {
      document.getElementById('showContent').innerHTML = displayText;
      openPopup('showPopup');
    } else {
      alert("لم يتم العثور على معلومات محفوظة.");
    }
  }

  // فتح نافذة تعديل الاهداف مع نسبة الإنجاز
  function openEditPopup() {
    var selectPersonElement = document.getElementById('selectPerson');
    selectPersonElement.innerHTML = "";

    // ملأ قائمة الاختيار بالاهداف المحفوظة
    for (var i = 0; i < userInformation.length; i++) {
      var option = document.createElement('option');
      option.value = i;
      option.text = "الهدف" + (i + 1);
      selectPersonElement.add(option);
    }

    loadPersonData(); // استرجاع بيانات الهدف المحدد للتعديل
    openPopup('editPopup');
  }

  // فتح نافذة حذف الاهداف
  function openDeletePopup() {
    var deletePersonElement = document.getElementById('deletePerson');
    deletePersonElement.innerHTML = "";

    // ملأ قائمة الاختيار بالاهداف المحفوظة
    for (var i = 0; i < userInformation.length; i++) {
      var option = document.createElement('option');
      option.value = i;
      option.text = "الهدف" + (i + 1);
      deletePersonElement.add(option);
    }

    openPopup('deletePopup');
  }

  // استرجاع بيانات الهدف المحدد للتعديل
/*  function loadPersonData() {
    var selectedIndex = document.getElementById('selectPerson').value;

    // إذا تم اختيار هدف، استرجاع بياناته لتعديلها
    if (selectedIndex !== "") {
      document.getElementById('editInfoTextarea').value = userInformation[selectedIndex].info;
      document.getElementById('progressSlider').value = userInformation[selectedIndex].progress || 0;
      updateVolumeIndicator();
    }
  }

  // تحديث عرض مؤشر النسبة
  function updateVolumeIndicator() {
    var progressSlider = document.getElementById('progressSlider');
    var volumeIndicator = document.getElementById('volumeIndicator');
    volumeIndicator.innerHTML = '' + progressSlider.value + '%';
  }*/

  // تأكيد حذف الهدف المحدد
  function confirmDelete() {
    closePopup('deletePopup');
  }/*
    var selectedIndex = document.getElementById('deletePerson').value;

    if (selectedIndex !== "") {
      var confirmed = confirm("هل أنت متأكد من رغبتك في حذف هذا الهدف؟");

      if (confirmed) {
        userInformation.splice(selectedIndex, 1);
        alert("تم حذف الهدف بنجاح.");
        closePopup('deletePopup');
      }
    } else {
      alert("الرجاء اختيار الهدف للحذف.");
    }
  }*/

  // إغلاق النوافذ
  function closePopup(popupId) {
    document.getElementById(popupId).style.display = 'none';
  }

  // حفظ معلومات الهدف الجديد
  function saveUserInfo() {
    closePopup('addPopup');
  }/*
    var info = document.getElementById('infoTextarea').value;
    var progress = 0; // القيمة الافتراضية لنسبة الإنجاز

    if (info) {
      userInformation.push({ info: info, progress: progress });
      alert("تم حفظ المعلومات الهدف: " + info);
      var divStyleElement = document.querySelector('.div_style');
        var newHeight = userInformation.length * 50; // يمكنك تعديل هذه القيمة حسب الاحتياج
        divStyleElement.style.minHeight = newHeight + 'px';
      closePopup('addPopup');
    } else {
      alert("الرجاء إدخال المعلومات.");
    }
  }*/

  // حفظ التعديلات على معلومات الهدف
  function saveEditedUserInfo() {
    closePopup('editPopup');
  }
    /*
    var selectedIndex = document.getElementById('selectPerson').value;
    var editedInfo = document.getElementById('editInfoTextarea').value;
    var editedProgress = document.getElementById('progressSlider').value;

    if (selectedIndex !== "" && editedInfo) {
      // تحديث بيانات الهدف المحدد
      userInformation[selectedIndex].info = editedInfo;
      userInformation[selectedIndex].progress = editedProgress;
      alert("تم تعديل الاهداف إلى: " + editedInfo);
      closePopup('editPopup');
    } else {
      alert("الرجاء اختيار الهدف للتعديل.");
    }
  }*/

  // فتح نافذة
  function openPopup(popupId) {
    document.getElementById(popupId).style.display = 'block';
  }
</script>
</body>
</html>
