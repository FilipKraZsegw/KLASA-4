<?php

$tab1 = array(7, 3, 1, 6, 9, 5, 4, 10, 2, 2);
echo "Krok 1: " . $tab1[4] . "<br>"; 

$tab1[6] = 12;
echo "Krok 2: " . $tab1[6] . "<br>";

$tab2 = $tab1;
echo "Krok 3: Skopiowałem zawartość tab1 do tab2<br>";

$tab3 = array();
for ($i = 0; $i < count($tab1); $i++) {
    $tab3[$i] = $tab1[$i] + $tab2[$i];
}
echo "Krok 4: Stworzyłen tab3 jako sumę elementów tab1 i tab2<br>";

$tab2 = array_reverse($tab1);
echo "Krok 5: tab2 po odwróceniu kolejności elementów tab1:<br>";
?>