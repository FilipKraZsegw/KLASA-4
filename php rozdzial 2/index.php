<?php

/*
$a = 72; // przypisujemy wartość zmiennej $a
if ($a%2 > 0) // reszta z dzielenia przez 2
{
  echo "Liczba nieparzysta <br>";
}
if ($a%2 == 0) // brak reszty z dzielenia przez 2
{
  echo "Liczba parzysta <br>";
}

if ($a > 0 && $a < 10) // $a jest większa niż 0 I jest mniejsza niż 10 - oba warunki muszą zostać spełnione
  echo "Liczba między 0 a 10 <br>";

if ($a < 0 || $a > 10) // $a jest mniejsza niż 0 LUB jest większa niż 10 - jeden z warunków musi zostać spełniony
  echo "Liczba mniejsza od 0 lub większa niż 10 <br>";

if ($a%2 > 0) // reszta z dzielenia przez 2
{
  echo "Liczba nieparzysta <br>";
}
else // brak reszty z dzielenia przez 2
{
  echo "Liczba parzysta <br>";
}


if ($a%8 == 0) // liczba podzielna przez osiem
  echo "Liczba podzielna przez osiem <br>";

elseif ($a%4 == 0) // liczba podzielna przez cztery
  echo "Liczba podzielna przez 4, ale nie przez 8 <br>";

elseif ($a%2 == 0) // liczba podzielna przez dwa
  echo "Liczba podzielna przez 2, ale nie przez 4 <br>";

else // żadna z powyższych
  echo "Liczba nieparzysta <br>";


 //sprawdzamy zmienną $a
  switch ($a) 
{
case 1:
  echo "Wartość zmiennej a to 1 <br>";
  break;

case 2:
  echo "Wartość zmiennej a to 2 <br>";
  break;

case 3:
  echo "Wartość zmiennej a to 3 <br>";
  break;

case 72:
  echo "Wartość zmiennej a to 72 <br>";
  break;

default:
  echo "Żadna z powyższych <br>";
  break;
}
 $zmienna  = 41;
while($zmienna < 101) // warunek kontynuacji pętli
{
  echo $zmienna."<br>";
  $zmienna+= 10;
} 

do // instrukcje do wykonania
{
  echo $zmienna."<br>";
  $zmienna-=10;
} 
while($zmienna > 0);

for($i=0; $i < 10; $i++)
{

echo "Siema kumplu nr.".$i." !<br>";

}

$odpowiedz = ($a>5) ? 'Większa od 5 <br>' : 'Mniejsza, bądź równa 5 <br>';

echo $odpowiedz;
*/


echo "tabliczka mnożenia!<br>";

for($i = 1; $i <= 10; $i++)
{
    for($j = 1; $j <= 10; $j++)
    {
        $wynik = $i * $j;

        if($wynik % 2 == 0)
            echo "<span style='color:blue;'>$wynik</span> ";
        else
            echo "<span style='color:green;'>$wynik</span> ";
    }

    echo "<br>";
}


$potega = 3;

switch($potega)
{
    case 2:
        for($i = 1; $i <= 10; $i++)
        {
            echo $i . "^2 = " . ($i * $i) . "<br>";
        }
        break;

    case 3:
        for($i = 1; $i <= 10; $i++)
        {
            echo $i . "^3 = " . ($i * $i * $i) . "<br>";
        }
        break;

    case 4:
        for($i = 1; $i <= 10; $i++)
        {
            echo $i . "^4 = " . ($i * $i * $i * $i) . "<br>";
        }
        break;

    default:
        echo "Zmienna musi mieć wartość 2, 3 lub 4<br>";
}























?>