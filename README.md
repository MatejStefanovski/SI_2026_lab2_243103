# SI 2026 Лабораториска вежба 2

Матеј Стефановски 243103  

---

## Control Flow Graph (CFG)

### searchBookByTitle

<img width="669" height="1081" alt="SearchBookByTitle drawio" src="https://github.com/user-attachments/assets/4a4a21d2-9fbc-4070-9629-9266b2226300" />

### borrowBook

<img width="679" height="1086" alt="BorrowBook drawio" src="https://github.com/user-attachments/assets/ccaa2c03-dd84-4ce0-a504-792b9e662ab6" />

---

## Цикломатска комплексност

### searchBookByTitle

Предикатни јазли:

- if (title.isEmpty())
- for loop
- if (title match && !borrowed)
- if (results.isEmpty())

**M = 5 + 1 = 6**

---

### borrowBook

Предикатни јазли:

- if (title.isEmpty() || author.isEmpty())
- for loop
- if (book match)
- if (!book.isBorrowed())

**M = 5 + 1 = 6**

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
