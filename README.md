# SI 2026 Лабораториска вежба 2

Име: Matej Stefanovski  
Индекс: 243103  

---

## Control Flow Graph (CFG)

### searchBookByTitle

Control Flow Graph

### borrowBook

Control Flow Graph
---

## Цикломатска комплексност

### searchBookByTitle

Предикатни јазли:

- if (title.isEmpty())
- for loop
- if (title match && !borrowed)
- if (results.isEmpty())

**M = 4 + 1 = 5**

---

### borrowBook

Предикатни јазли:

- if (title.isEmpty() || author.isEmpty())
- for loop
- if (book match)
- if (!book.isBorrowed())

**M = 4 + 1 = 5**

---

## Тестирање според Every Statement

### searchBookByTitle

| Тест случај | Опис |
|------------|------|
| Test 1 | Празен наслов → фрла исклучок |
| Test 2 | Нема совпаѓање → враќа null |
| Test 3 | Постојна книга → враќа листа |
| Test 4 | Книга е позајмена → не се враќа |

**Минимален број на тест случаи: 4**

(покриено со `searchBookEveryStatementTest`)

---

## Тестирање според Every Branch

### borrowBook

| Тест случај | Опис |
|------------|------|
| Test 1 | Невалиден влез → exception |
| Test 2 | Книга постои и се позајмува успешно |
| Test 3 | Книга веќе позајмена → exception |
| Test 4 | Книга не постои → exception |

**Минимален број на тест случаи: 4**

(покриено со `borrowBookEveryBranchTest`)

---

# Тестирање според Multiple Condition

## `borrowBook` услов

### Услов:
```java
(title.isEmpty() || author.isEmpty())
```

| title.isEmpty() | author.isEmpty() | Тест |
|---|---|---|
| T | T | `lib.borrowBook("", "")` |
| T | F | `lib.borrowBook("", "A")` |
| F | T | `lib.borrowBook("Test", "")` |
| F | F | `lib.borrowBook("Test", "A")` |

### Минимален број на тест случаи:
```text
4
```

### Покриеност:
```text
borrowBookMultipleConditionTest
```

---

## `searchBookByTitle` услов

### Услов:
```java
book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()
```

| title match | not borrowed | Тест |
|---|---|---|
| T | T | постои книга и не е позајмена |
| T | F | книга е позајмена |
| F | T | различен наслов |
| F | F | различен наслов + позајмена |

### Минимален број на тест случаи:
```text
3
```

### Покриеност:
```text
searchBookMultipleConditionTest
```
