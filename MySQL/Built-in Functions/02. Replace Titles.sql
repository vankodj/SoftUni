SELECT REPLACE(`title`,"The","***")
FROM `books`
WHERE substring(`title` FROM 1 FOR 3)= "The"
ORDER BY `id`;