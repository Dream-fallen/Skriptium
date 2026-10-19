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

## Grammar (EBNF)
The following EBNF describes the core syntax required by this specification. It is intentionally compact and focuses on the file-level constructs (syntax declaration and module requiring). Terminals are written in quotes. Lowercase names are non-terminals.

```
EBNF ::= file

file ::= syntax_declaration { module_decl } { statement }

syntax_declaration ::= "using" "py" | "using" "js"

module_decl ::= "require" "(" MODULE_NAME ")" [ modifier ]

modifier ::= alias_modifier | priority_modifier
alias_modifier ::= "with" "alias" STRING
priority_modifier ::= "with" "priority" PRIORITY

MODULE_NAME ::= IDENT | STRING
IDENT ::= letter { letter | digit | '_' | '-' }
STRING ::= '"' { any_char_except_quote } '"' | '\'' { any_char_except_quote } '\''
PRIORITY ::= "1" | "2" | "3" | "4" | "5"

statement ::= any_text_until_eol_or_block

any_text_until_eol_or_block ::= /* placeholder for language-specific statements provided by modules or the core language. */

letter ::= /* A-Z a-z */

digit ::= /* 0-9 */

```

Notes:
- The `syntax_declaration` must appear exactly once at the top of the file; parsers should treat its absence as a syntax error.
- `module_decl` entries may appear multiple times; each `require` must precede usage of that module's syntax.
- The `modifier` is optional and may be either an alias or a priority (but not both). Implementations should validate this constraint.
- `statement` is intentionally underspecified here: module authors provide their own grammars for added syntax, which are composed into the main grammar after `require`-time resolution.

If you'd like, I can expand this into a full BNF covering core expressions, blocks for both `py` and `js` modes, and a concrete token specification (lexical grammar).