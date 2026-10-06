# Design philosophy

## Vision
Skriptium is a modern overhaul of the Minecraft Skript language. The goal is to move away from the English-like syntax (which can often become verbose or ambiguous) and move toward standard programming patterns found in Python and JavaScript.

## Core Principles
- **Modernity:** Utilizing structured blocks and explicit declarations.
- **Efficiency:** Removing redundant Skript syntax to make scripts shorter and more readable.
- **Flexibility:** Allowing the developer to choose their preferred coding style (`py` vs `js`) without changing the underlying logic.
- **Modularization:** Replacing global addon effects with an explicit module-loading system.

## Non-Goals
- **Backwards Compatibility:** Skriptium is NOT backwards compatible with standard `.sk` files. This was a conscious decision to ensure the language remains clean and optimized.
- **1:1 Porting:** Not every single Skript feature will be ported; redundant or obsolete syntax will be omitted.
