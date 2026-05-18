<?php require 'db.php'; ?>

<?php
if (isset($_SESSION['log_id'])) {

    $status = $_SESSION['formularz_wyslany'] ? 'tak' : 'nie';
    $log_id = $_SESSION['log_id'];

    mysqli_query($conn, "
        UPDATE logi
        SET formularz_wyslany = '$status'
        WHERE id = $log_id
    ");
}

session_unset();
session_destroy();

header("Location: login.php");
exit();