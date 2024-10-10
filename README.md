# Вычислитель отличий / Generate Difference

Учебный проект школы программирования ["Hexlet"](https://ru.hexlet.io/)

---

### Hexlet tests and linter status:

[![Actions Status](https://github.com/VIIIunknownVIII/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/VIIIunknownVIII/java-project-71/actions)
[![custom-check](https://github.com/VIIIunknownVIII/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/VIIIunknownVIII/java-project-71/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/1a1e54aa36a24f9272ae/maintainability)](https://codeclimate.com/github/VIIIunknownVIII/java-project-71/maintainability)

---

### Демонстрация:

<a href="https://asciinema.org/a/0ugHFCEYdzklfN2ATWRK6yOt8" target="_blank">
    <img src="https://asciinema.org/a/0ugHFCEYdzklfN2ATWRK6yOt8.svg" alt="asciicast" />
</a>

---

## Описание

**Вычислитель отличий** – это программа, которая определяет разницу между двумя структурами данных. Эта задача широко используется в различных сферах, например, при тестировании или отслеживании изменений в конфигурационных файлах. Существует множество онлайн-сервисов для решения этой задачи, например [jsondiff.com](http://www.jsondiff.com/).

---

### Возможности утилиты:

- Поддержка различных форматов входных данных: **YAML**, **JSON**
- Генерация отчета в трех форматах: **plain text**, **stylish**, **json**

---

## Цели проекта:

### 1. Структуры данных и алгоритмы:
- Научиться описывать внутреннее представление различий между файлами для удобства обработки.
- Работать с деревьями и рекурсивными алгоритмами.

### 2. Архитектура:
- Выполнять операции: чтение файлов, парсинг входных данных, построение дерева различий, формирование итогового отчета.
- Разработка модульной архитектуры и использование абстракций.
- Работа с параметрами командной строки для улучшенного взаимодействия с операционной системой.

### 3. Работа с документацией:
- Использование популярных библиотек:
  - [commander.js](https://github.com/tj/commander.js)
  - [ini](https://github.com/npm/ini)
  - [js-yaml](https://github.com/nodeca/js-yaml)
  - [lodash](https://lodash.com/)
  - [jest](https://jestjs.io/)

---

## Установка и запуск проекта

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/VIIIunknownVIII/java-project-71.git
