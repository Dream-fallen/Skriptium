# Technical Specifications

## File Format
- **Extension:** `.skm`

## Syntax Modes
Every `.skm` file must begin with a syntax declaration. This tells the compiler how to handle blocks and indentation.

### Option A: Python Style
- **Declaration:** `using py`
- **Logic:** Uses indentation to define code blocks. No curly braces.

### Option B: JavaScript Style
- **Declaration:** `using js`
- **Logic:** Uses curly braces `{ }` to define code blocks.

---

## The Module System (`require`)
Addons are treated as modules. Modules must be explicitly required before their syntax can be used.

### Syntax
`require('module_name') [modifier]`

### Modifiers
1. **Alias:** `with alias 'name'`
   - Creates a unique namespace for the module.
   - Example: `require(skquery) with alias query`
2. **Priority:** `with priority (1|2|3|4|5)`
   - Determines which module takes precedence in the event of a syntax conflict.
   - **1** = Highest Priority | **5** = Lowest Priority.
   - Example: `require(tuske) with priority 1`

### Module Constraints
- A module can have an **Alias** OR a **Priority**.
- Using both is generally discouraged unless resolving a specific namespace conflict between two modules with the same alias.

## Targeted Modules (Addons)
The following addons will be implemented as native Skriptium modules:
- Skellet
- SkQuery
- skRayFall
- TuSKe
- SkBee
