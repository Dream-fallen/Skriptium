# Skriptium

**Skriptium** is a complete overhaul of the Skript plugin language. It replaces Skript's english like syntax with a language inspired by **Python** and **JavaScript**.

**NOTE:** Skriptium is **NOT** backwards compatible with normal Skript. Certain redundant syntax has been removed.

## Getting started

Every Skriptium file uses the `.skm` extension. You must declare your preferred syntax engine at the very top of your file.

### Option A: Python Style (`using py`)
Uses colons (`:`) and strict code indentation.

```python
using py
require(skellet)

on join:
    let player = event.player
    player.sendMessage("Welcome to the server!")
```

### Option B: JavaScript Style (`using js`)
Uses standard blocks enclosed in curly braces (`{}`).

```javascript
using js
require(skellet)

on join() {
    let player = event.player;
    player.sendMessage("Welcome to the server!");
}
```

---

## Addons

To manage addon dependencies and eliminate syntax collisions, Skriptium uses explicit scoping rules. You **must** choose either an **Alias** or a **Priority** when loading conflicting packages.

### 1. Isolated Namespaces (Aliases)
```javascript
using js
require(skquery) with alias query

// Syntax is isolated under the 'query' namespace
```

### 2. Priority Hierarchy
Priority numbers range from `1` (Highest Precedence) to `5` (Lowest Precedence).
```python
using py
require(tuske) with priority 1
require(skbee) with priority 2

// If TuSKe and SkBee share a syntax rule, TuSKe overrides it
```
---
# This project is proudly licensed under the MIT License.
