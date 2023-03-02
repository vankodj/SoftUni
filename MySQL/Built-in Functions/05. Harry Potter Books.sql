SELECT `title`
FROM `books`
WHERE SUBSTRING(`title`, 1,12) = "Harry Potter"
ORDER BY `id`;