# Szyfr
Projekt zawiera moduł io, moduł szyfru Cezara, moduł kodowania Morsem oraz Maina. Służy on do szyfrowania i odszyfrowywania podanego tekstu.
### Użycie:
Użytkownik po uruchomieniu Maina podaje ścieżkę do pliku z tekstem, potem będzie kierowany poprzez komunikaty programu. Wynik operacji szyfrowania lub odszyfrowywania można znaleźć w pliku output.txt.

W przypadku korzystania z szyfrowania alfabetem Morse'a wszystkie znaki poza literami, `[space]`, `\n` zostaną zignorowane. Po zaszyfrowaniu litery będą oddzielone znakami '/', słowa potrójną spacją, a linie siedmiokrotną spacją.

Podając wejście do odszyfrowania należy ściśle stosować się do tej konwencji. Przykład można znaleźć w pliku `morse_decode_input.txt`.
### Testowanie:
W pliku `TestCezar.java` znajdują się proste testy sprawdzające poprawność 
szyfrowania i odszyfrowywania tekstu za pomocą szyfru Cezara.
