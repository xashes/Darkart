
(import (darkart py ffi)
        (darkart py call)
        (darkart py eval))


(py-init)

;; test pass values

(define x 9)
(py-define 'x x)
(define k (py/import-import-module "__main__"))
(define dic (py/module-get-dict k))
(define y (py/long-as-long (py/run-string "x * x" py-eval-input dic dic)))
(display (+ y 8))
(newline)

;; test list pass and operate

(define x '(1 2 3 4 5))
(define t (py/list->list x))
(define a (py/list-get-item t 0))
(define b (py/list-get-item t 1))
(define c (py/list-get-item t 2))
(define d (py/list-get-item t 3))
(define e (py/list-get-item t 4))
(display (py/long-as-long a))
(newline)
(display (py/long-as-long b))
(newline)
(display (py/long-as-long c))
(newline)
(display (py/long-as-long d))
(newline)
(display (py/long-as-long e))
(newline)


(define x `#(1 2 3 4 5))
(define t (py/vector->list x))
(define a (py/list-get-item t 0))
(define b (py/list-get-item t 1))
(define c (py/list-get-item t 2))
(define d (py/list-get-item t 3))
(define e (py/list-get-item t 4))
(display (py/long-as-long a))
(newline)
(display (py/long-as-long b))
(newline)
(display (py/long-as-long c))
(newline)
(display (py/long-as-long d))
(newline)
(display (py/long-as-long e))
(newline)

;; test tuple pass and operate

(define x '(1 2 3 4 5))
(define t (list->*tuple x))
(define a (py/tuple-get-item t 0))
(define b (py/tuple-get-item t 1))
(define c (py/tuple-get-item t 2))
(define d (py/tuple-get-item t 3))
(define e (py/tuple-get-item t 4))
(display (py/long-as-long a))
(newline)
(display (py/long-as-long b))
(newline)
(display (py/long-as-long c))
(newline)
(display (py/long-as-long d))
(newline)
(display (py/long-as-long e))
(newline)


(define x `#(1 2 3 4 5))
(define t (py/vector->tuple x))
(define a (py/tuple-get-item t 0))
(define b (py/tuple-get-item t 1))
(define c (py/tuple-get-item t 2))
(define d (py/tuple-get-item t 3))
(define e (py/tuple-get-item t 4))
(display (py/long-as-long a))
(newline)
(display (py/long-as-long b))
(newline)
(display (py/long-as-long c))
(newline)
(display (py/long-as-long d))
(newline)
(display (py/long-as-long e))
(newline)


;test call numpy 


(define x '(1 2 3 4 5 6 7 8))
(define t (list->plist int x))
(define np (py/import-import-module "numpy"))
(define array (py/object-get-attr-string np "array"))
(define cosin (py/object-get-attr-string np "cos"))
(define ndarray (py/object-get-attr-string np "ndarray"))
(define tolist (py/object-get-attr-string ndarray "tolist"))
(define arr (py/object-call-object array (py-args t)))
(define lst (py/object-call-object cosin (py-args arr)))
(define pylst (py/object-call-object tolist (py-args lst)))
(display (plist->list 'float pylst))
(newline)

;test type check

(display (py/int-check? (py/int-from-long 7)))
(newline)
(display (py/int-check? (int 7)))
(newline)
(display (*int? (int 7)))
(newline)
(display (*int? (float 7.0)))
(newline)
(display (*float? (float 7.0)))
(newline)
(display (*float? (int 7)))
(newline)
(display (plist? (list->plist int '(1 2 3 4 5 6))))
(newline)
(display (plist? (list->ptuple int '(1 2 3 4 5 6))))
(newline)
(display (ptuple? (list->ptuple int '(1 2 3 4 5 6))))
(newline)
(display (ptuple? (list->plist int '(1 2 3 4 5 6))))
(newline)
(display (psequ? (list->plist int '(1 2 3 4 5 6))))
(newline)
(display (pdict? (alist->pdict int `((a . 1)(b . 2)))))
(newline)
(display (pdict? (list->plist int '(1 2 3 4 5 6))))
(newline)
(display (pmap? (alist->pdict int `((a . 1)(b . 2)))))
(newline)
(display (pmap? (list->plist int '(1 2 3 4 5 6))))


; test nesting plist / ptuple

(display (plist->list (list->plist int '((((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))(((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))))))
(newline)
(display (plist->list *int (list->plist int '((((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))(((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))))))
(newline)
(display (plist->list* (list->plist int '((((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))(((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))))))
(newline)
(display (ptuple->list (list->ptuple int '((((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))(((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))))))
(newline)
(display (ptuple->list *int (list->ptuple int '((((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))(((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))))))
(newline)
(display (ptuple->list* (list->ptuple int '((((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))(((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))))))
(newline)
(display (plist->vector (list->plist int '((((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))(((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))))))
(newline)
(display (plist->vector *int (list->plist int '((((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))(((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))))))
(newline)
(display (plist->vector* (list->plist int '((((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))(((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))))))
(newline)
(display (ptuple->vector (list->ptuple int '((((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))(((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))))))
(newline)
(display (ptuple->vector *int (list->ptuple int '((((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))(((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))))))
(newline)
(display (ptuple->vector* (list->ptuple int '((((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))(((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))))))
(newline)

; test alist dict pass

(display (pdict->alist (alist->pdict '((a . 8)(b . 9.5)(c . "c")))))
(newline)

; test complex parser

(display 
    (*complex
        (py-add 
            (complex 4.0-3i)
            (complex 3.0+5i))))
(newline)

; test plist-ref plist-set!

(define x (list->plist int '((((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4)))(((1 2 3 4) (1 2 3 4) (1 2 3 4))((1 2 3 4) (1 2 3 4) (1 2 3 4))))))

(plist-set! x 0 1 2 3 (int 100))
(display (*int (plist-ref x 0 1 2 3)))
(newline)
(display (plist->list (plist-sref x 0 1 2 (0 4))))
(newline)
(plist-sset! x 0 1 2 (0 4) (list->plist '(90 91 92 93)))
(display (plist->list (plist-ref x 0 1 2 )))
(newline)
(py-fin)

