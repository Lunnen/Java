-------------------------------------------------

# Uppgift/Övning JavaStreams\
I gitrepot kommer ni hitta en java fil (Arrayer.txt) där det finns två ordentligt\
stora arrayer. Det är dessa vi ska köra Stream på och ta reda på spännande\
och intressanta (nåja) fakta om.

Övningar/ bra platser att läsa\
https://stackify.com/streams-guide-java-8/ \
https://www.w3schools.com/java/java_lambda.asp \
https://dzone.com/articles/become-a-master-of-java-streams-part-1-creating-st \
https://dzone.com/articles/become-a-master-of-java-streams-part-2-intermediat \
www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---practice \
https://www.youtube.com/watch?v=t1-YZ6bF-g0&t=389s \
och en sågning av det hela: \
https://jaxenter.com/java-performance-tutorial-how-fast-are-the-java-8-streams-118830.html

-------------------------------------------------

inlämning\
src-mappen till nedanstående lämnas in senast fredag (22/1)

-------------------------------------------------

Del 1\
Använd java streams Skriv lämplig kod som besvarar följande frågor:
1. Hur många ord med fler än 8 bokstäver innhåller texten?
2. Hur många unika ord innehåller texten?
3. hur många ord med färre än 4 tecken?
4. Hur många unika ord med fler än 8 bokstäver?
5. Vilken är den genomsnittliga ordlängden (Hint! Kolla upp OptionalDouble: https://docs.oracle.com/javase/8/docs/api/java/util/OptionalDouble.html)
6. Det totala antalet tecken i listan (dvs summan av längden av alla ingående strängar)?
7. Deklarera två predicate och använd dessa (med streams) för att svara
på om a) Är alla ord kortare än 12 tecken? b) Är all ord längre än två
bokstäver?

-------------------------------------------------

Del 2\
Array nummer2 är en Double array med hjälp av streams:
1. Hur många av talen är större än 1000?
2. använd map, filter och distinct för att skapa en doublearray som innehåller alla tal som är mindre än 1000 och har en heltalsdel som är
jämnt delbara med tre
3. Vilken är summan av alla tal i arrayen under 500?
4. Medelvärdet för alla tal mellan 2000 och 3000?
5. Vilket är det Största värdet respektiva minsta värdet i arrayen?

-------------------------------------------------

Del 3\
Skapa en klass, MyObject som innehåller tre instansvariabler, en boolean -\
bool, en int -value och en String - name. Gör en passande konstruktor och\
lägg till getters och setters. Skapa sedan en metod som genererar 50 instanser\
av dessa med slumpmässiga Heltal(1-50) och booleans samt unika names och\
och placerar in dessa i en array. Gör lämpligen också en toString-metod för\
att kunna skriva ut ditt objekt på lämpligt sätt.\
Använd sedan javaStreams för att:
1. Skapa en Array som bara innehåller objekt vars value överstiger 20.
2. Beräkna medelvärdet av alla values
3. Byta namnet till this is trueför alla objekt vars boolean är true.

-------------------------------------------------
