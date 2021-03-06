# Darkart: Chez Scheme's Forign Library Interface

A binary interface let Chez Scheme use Python, Lua, Ruby etc's library

This project is inspired by the Julia language. The FFI interface provided by Chez is used to embed the interpreter or JIT compiler of other languages into the Scheme program (CPython, Luajit etc) or to link the compiled object code with the C binary interface. (OCaml, Golang etc).

Implementation priority: Python ✅ > Julia > Javascript > OCaml


```
(define np (py-import 'numpy))

(define ndarray (py-get np 'ndarray))
(define np-pi (py-get np 'pi))
(define np-array (py-get np 'array))
(define np-sin (py-get np 'sin))
(define np-tolist (py-get ndarray 'tolist))

(define get-sin
    (lambda (lst)
        (plist->list
            (py-call np-tolist
                (py-call np-sin
                    (py-div
                        (py-mul np-pi 
                            (py-call np-array
                                (list->plist int lst)))
                        (int 180)))))))

(get-sin '(1 2 3 4 5 6 7 8))

=>
(0.01745240643728351 0.03489949670250097 0.05233595624294383 0.0697564737441253 
0.08715574274765817 0.10452846326765346 0.12186934340514748 0.13917310096006544)

```



Sources:

https://github.com/JuliaPy/PyCall.jl/blob/master/src/PyCall.jl

https://docs.python.org/2/c-api/index.html

https://docs.python.org/2.5/ext/callingPython.html

http://www.linux-nantes.org/~fmonnier/OCaml/ocaml-wrapping-c.html

http://caml.inria.fr/pub/docs/manual-ocaml-4.00/manual033.html#htoc281


Deprecated attempt:

† https://github.com/guenchi/Py-call