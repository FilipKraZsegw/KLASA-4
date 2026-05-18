<?php
$conn = mysqli_connect("localhost", "root", "", "sesja");

if (!$conn) {
    die("Błąd połączenia: " . mysqli_connect_error());
}

session_start();
?>