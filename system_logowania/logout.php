<?php require 'db.php'; ?>

<?php
if (isset($_SESSION['log_id'])) {
    $status = $_SESSION['formularz_wyslany'] ? 'tak' : 'nie';

    $stmt = $pdo->prepare("UPDATE logi SET formularz_wyslany = ? WHERE id = ?");
    $stmt->execute([$status, $_SESSION['log_id']]);
}

session_destroy();
header("Location: login.php");
exit;