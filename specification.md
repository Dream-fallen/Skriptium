# Specifications (ver 1.0.0.0)

## Constraints
1. All scripts must terminate in `.skm`.
2. The first non-comment line of any `.skm` file must strictly match `^using (py|js)$`. If missing or invalid, the compiler will complain.

## Modules
Modules are imported using `require(<module_name>)`. 
*   A script cannot declare both a `with alias` and a `with priority` modifier on the same module import line. Doing so will also make the compiler complain.
*   Built-in compiler syntax maps directly to priority `0`. User-defined explicit priorities cover values `1` through `5`.
