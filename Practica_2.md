# PRACTICA 2
## Reconocimiento de palabras con Autómatas Finitos Deterministas
### Naomi Romero López
Inciso a)
Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴 =
{0, 1}, que acepte el conjunto de palabras del lenguaje 𝐿 = {0𝑥 | 𝑥 ∈ {0,1}∗ }
AFD=(Σ,Q,δ,q0,F)

Donde:

Σ = {0,1}  
Q = {start, q1, q2}  
q₀ = start  
F = {q1}  

Función de transición δ:

δ(start,0) = q1  
δ(start,1) = q2  
δ(q1,0) = q1  
δ(q1,1) = q1  
δ(q2,0) = q2  
δ(q2,1) = q2  

Tabla de trasnsición de estados
| Estado  | 0  | 1  |
| ------- | -- | -- |
| → start | q1 | q2 |
| * q1    | q1 | q1 |
| q2      | q2 | q2 |

<img width="1911" height="979" alt="Captura de pantalla 2026-03-03 134732" src="https://github.com/user-attachments/assets/6e6dbd6b-7b8d-414b-94a8-35bc3d34e860" />

Inciso b)
Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴 =
{0, 1}, que acepte el conjunto de palabras del lenguaje 𝐿 = {𝑥1 | 𝑥 ∈ {0,1}) }

Donde: 
Σ = {0,1}  
Q = {start, s0, s1, s2}  
q₀ = start  
F = {s2}  

Función de transición δ:

δ(start,0) = s0  
δ(start,1) = s1  
δ(s0,0) = s0  
δ(s0,1) = s2  
δ(s1,0) = s1    
δ(s1,1) = s2    
δ(s2,0) = s1     
δ(s2,1) = s2    

Tabla de trasnsición de estados
| Estado  | 0  | 1  |
| ------- | -- | -- |
| → start | s0 | s1 |
| s0      | s0 | s2 |
| s1      | s1 | s2 |
| *s2     | s1 | s2 |


<img width="1917" height="907" alt="Captura de pantalla 2026-03-03 141325" src="https://github.com/user-attachments/assets/77cc9694-5005-45a3-a3ae-fe81675a643e" />


Inciso c)
Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴 =
{0, 1}, que acepte el conjunto de palabras del lenguaje 𝐿 = {𝑥01𝑦 | 𝑥, 𝑦 ∈ {0,1}∗ }

Donde:
Σ = {0,1}  
Q = {start, s2, s3}  
q₀ = start  
F = {s3}  

Función de transición δ:

δ(start,0) = s2  
δ(start,1) = start 

δ(s2,0) = s2
δ(s2,1) = s3

δ(s3,0) = s3  
δ(s3,1) = s3  

Tabla de trasnsición de estados
| Estado  | 0  | 1  |
| ------- | -- | -- |
| → start | s2 | start |
| s2      | s2 | s3 |
| *s3     | s3 | s3 |


<img width="1915" height="919" alt="Captura de pantalla 2026-03-03 150153" src="https://github.com/user-attachments/assets/7f8169e7-efce-4fba-9a66-957cb67cd804" />

Inciso d)
Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴 =
{0, 1}, que acepte el conjunto de palabras del lenguaje 𝐿 = {𝑥110𝑦 | 𝑥, 𝑦 ∈ {0,1}∗ }

Donde:
Σ = {0,1}  
Q = {start, s0, s1, s2}  
q₀ = start  
F = {s2}  

Función de transición δ:

δ(start,0) = start  
δ(start,1) = s0  
δ(s0,0) = start
δ(s0,1) = s1  
δ(s1,0) = s2    
δ(s1,1) = s1    
δ(s2,0) = s2      
δ(s2,1) = s2  

Tabla de trasnsición de estados
| Estado  | 0  | 1  |
| ------- | -- | -- |
| → start | start | s0 |
| s0      | sstart | s1 |
| s1      | s2 | s1 |
| *s2     | s2 | s2 |

<img width="1901" height="912" alt="Captura de pantalla 2026-03-03 152222" src="https://github.com/user-attachments/assets/870ed3fd-4500-4f1f-b0b9-8301cea20566" />


Inciso e)
Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴 =
{𝑎, 𝑏, 𝑐}, que acepte el conjunto de palabras del lenguaje 𝐿 = {𝑎𝑐𝑥𝑎𝑏 | 𝑥 ∈ {𝑎, 𝑏, 𝑐}∗ }

Donde:
Σ = {a,b,c}  
Q = {start, s0, s1, s2, s3, estado_error}  
q₀ = start  
F = {s3}  

Función de transición δ:

δ(start,a) = s0  
δ(start,b) = estado_error  
δ(start,c) = estado_error  
δ(s0,a) = estado_error
δ(s0,b) = estado_error 
δ(s0,c) = s1 
δ(s1,a) = s2    
δ(s1,b) = s1    
δ(s1,c) = s1  
δ(s2,a) = s2     
δ(s2,b) = s3  
δ(s2,c) = s1 
δ(s3,a) = s2     
δ(s3,b) = s1  
δ(s3,c) = s1 
δ(estado_error,a) = estado_error
δ(estado_error,b) = estado_error
δ(estado_error,c) = estado_error

Tabla de trasnsición de estados
| Estado  | a  | b  | c  |
| → start | s0 | e_er | e_er |
| s0      | e_er | e_er | s1 |
| s1      | s2 | s1 | s1 |
| s2      | s2 | s3 | s1 |
| *s3     | s2 | s1 | s1  |
| e_er     | e_er | e_er | e_er |

<img width="1919" height="977" alt="Captura de pantalla 2026-03-03 160616" src="https://github.com/user-attachments/assets/bab75de0-de38-48f0-a524-fe2573d069df" />


Inciso f)
 Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴 =
{𝑎, 𝑏, 𝑐}, que acepte el conjunto de palabras del lenguaje 𝐿 = {𝑎𝑐𝑥𝑧 | 𝑥 ∈ {𝑎. 𝑏, 𝑐}∗ 𝑦 𝑧 ≠ 𝑎𝑏 }

Donde:
Σ = {a,b,c}  
Q = {start, s0, s5, s7, s9, s10, s11, e_er}  
q₀ = start  
F = {s7, s5, s10, s9, s11}

Función de transición δ:

δ(start,a) = s0  
δ(start,b) = e_er  
δ(start,c) = e_er   
δ(s0,a) = e_er  
δ(s0,b) = e_er  
δ(s0,c) = s5  
δ(s5,a) = s7  
δ(s5,b) = s10  
δ(s5,c) = s9  
δ(s7,a) = e_er  
δ(s7,b) = e_er  
δ(s7,c) = s11  
δ(s9,a) = s9  
δ(s9,b) = e_er  
δ(s9,c) = s9  
δ(s10,a) = s10  
δ(s10,b) = s7  
δ(s10,c) = s10
δ(s11,a) = s11    
δ(s11,c) = s11 
δ(e_er,a) = s7  
δ(e_er,b) = s10  
δ(e_er,c) = s5  

*Tabla de trasnsición de estados*
| Estado  | a  | b  | c  |
| ------- | -- | -- | -- |
| → start | s0 | e_er | e_er |
| s0      | e_er | e_er | s5 |
| * s5    | s7 | s10 | s9 |
| * s7    | se_er | e_er | s11 |
| * s9    | s9 | e_er | s9 |
| * s10   | s10 | s7 | s10 |
| * s11   | s11 |  | s11 |
| e_er  | s7 | s9 | s5 |

<img width="1908" height="944" alt="Captura de pantalla 2026-03-03 180229" src="https://github.com/user-attachments/assets/9346acc0-6480-40d1-8387-fb17aadc25de" />


Inciso g)
 Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴 =
{𝑎, 𝑏, 𝑐, 𝑑}, que acepte el conjunto de palabras del lenguaje 𝐿 = {𝑎𝑐𝑏𝑥𝑧 | 𝑥 ∈ {𝑎, 𝑏, 𝑐, 𝑑}∗ 𝑦 𝑧 ≠ 𝑏𝑑}

Donde:

Σ = {a,b,c,d}  
Q = {start, s0, e_er, s2, s3, s4, s5, s_6}  
q₀ = start  
F = {s3, s4, s5, s6}

Función de transición δ:

δ(start,a) = s0  
δ(start,b) = e_er 
δ(start,c) = e_er  
δ(start,d) = e_er  
δ(s0,a) = s2  
δ(s0,b) = e_er  
δ(s0,c) = e_er  
δ(s0,d) = e_er  
δ(e_er,a) = s3  
δ(e_er,b) = s3  
δ(e_er,c) = s3  
δ(e_er,d) = e_er  
δ(s2,a) = e_er  
δ(s2,b) = s3  
δ(s2,c) = e_er  
δ(s2,d) = e_er  
δ(s3,a) = s4  
δ(s3,b) = s5  
δ(s3,c) = s5  
δ(s3,d) = e_er  
δ(s4,a) = s4  
δ(s4,b) = s4  
δ(s4,c) = s4  
δ(s4,d) = e_er  
δ(s5,a) = s5  
δ(s5,b) = s5  
δ(s5,c) = s5  
δ(s5,d) = e_er 
δ(s6,a) = s5  
δ(s6,b) = s5  
δ(s6,c) = s5  
δ(s6,d) = e_er 

*Tabla de trasnsición de estados*
| Estado  | a     | b     | c     | d     |
|---------|-------|-------|-------|-------|
| → start | s0    | e_er  | e_er  | e_er  |
| s0      | s2    | e_er  | e_er  | e_er  |
| e_er    | s3    | s3    | s3    | e_er  |
|* s2      | e_er  | s3    | e_er  | e_er  |
|* s3      | s4    | s5    | s5    | e_er  |
|* s4      | s4    | s4    | s4    | e_er  |
|* s5      | s5    | s5    | s5    | e_er  |
|* s6      | s5    | s5    | s5    | e_er  |

<img width="1919" height="912" alt="Captura de pantalla 2026-03-03 181544" src="https://github.com/user-attachments/assets/c179b7b0-b330-4f4d-8323-03c2451cc501" />


Inciso h)
Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴 =
{𝑎, 𝑏, 𝑐, 𝑑}, que acepte el conjunto de palabras 𝐿 = {𝑐𝑎𝑏𝑎𝑥𝑧 | 𝑥 ∈ {𝑎, 𝑏, 𝑐, 𝑑}∗ 𝑦 𝑧 ≠ 𝑎𝑏}

<img width="1909" height="931" alt="Captura de pantalla 2026-03-03 192155" src="https://github.com/user-attachments/assets/3a97e34c-5dd4-41a2-8b20-1ca69aea1f66" />

Donde:

Σ = {a,b,c,d}  
Q = {start, s0, s1, s2, s3, s4, s5, s8, s9}  
q₀ = start  
F = {s4, s5, s8, s9}

Función de transición δ:

δ(start,a) = s0  
δ(start,b) = s0  
δ(start,c) = s1  
δ(start,d) = s0  
δ(s0,a) = s4  
δ(s0,b) = s0  
δ(s0,c) = s4  
δ(s0,d) = s4  
δ(s1,a) = s2 
δ(s1,b) = s0  
δ(s1,c) = s0  
δ(s1,d) = s0  
δ(s2,a) = s0  
δ(s2,b) = s3  
δ(s2,c) = s0  
δ(s2,d) = s0  
δ(s3,a) = s4  
δ(s3,b) = s0  
δ(s3,c) = s0  
δ(s3,d) = s0  
δ(s4,a) = s5  
δ(s4,b) = s0  
δ(s4,c) = s8  
δ(s4,d) = s9  
δ(s5,a) = s5  
δ(s5,b) = s0  
δ(s5,c) = s5  
δ(s5,d) = s5  
δ(s8,a) = s8  
δ(s8,b) = s0  
δ(s8,c) = s8  
δ(s8,d) = s8 
δ(s9,a) = s9  
δ(s9,b) = s0  
δ(s9,c) = s9  
δ(s9,d) = s9 

*Tabla de trasnsición de estados*
| Estado   | a   | b   | c   | d   |
|----------|-----|-----|-----|-----|
| → start  | s0  | s0  | s1  | s0  |
| s0       | s4  | s0  | s4  | s4  |
| s1       | s2  | s0  | s0  | s0  |
| s2       | s0  | s3  | s0  | s0  |
| s3       | s4  | s0  | s0  | s0  |
| * s4     | s5  | s0  | s8  | s9  |
| * s5     | s5  | s0  | s5  | s5  |
| * s8     | s8  | s0  | s8  | s8  |
| * s9     | s9  | s0  | s9  | s9  |

Inciso i)
Obtenga un Autómata Finito Determinista (AFD) dado el lenguaje definido en el alfabeto 𝛴 =
{𝑎, 𝑏, 𝑐}, que acepte el lenguaje 𝐿 = {𝑎$𝑐𝑏*| 𝑛 > 0 𝑦 𝑚 > 0 }

<img width="1916" height="908" alt="Captura de pantalla 2026-03-03 193058" src="https://github.com/user-attachments/assets/9e24093e-a805-46a4-8bf6-a3706b582c2c" />
Donde:

Σ = {a,b,c}  
Q = {start, s0, s1, s2, s3}  
q₀ = start  
F = {s2} 

Función de transición δ:

δ(start,a) = s0  
δ(start,b) = s3  
δ(start,c) = s3  
δ(s0,a) = s0  
δ(s0,b) = s3  
δ(s0,c) = s1  
δ(s1,a) = s3  
δ(s1,b) = s2  
δ(s1,c) = s3  
δ(s2,a) = s3  
δ(s2,b) = s2  
δ(s2,c) = s3  
δ(s3,a) = s3  
δ(s3,b) = s3  
δ(s3,c) = s3  

*Tabla de trasnsición de estados*
| Estado  | a  | b  | c  |
| ------- | -- | -- | -- |
| → start | s0 | s3 | s3 |
| s0      | s0 | s3 | s1 |
| s1      | s3 | s2 | s3 |
| * s2    | s3 | s2 | s3 |
| s3      | s3 | s3 | s3 |

Inciso j)
{𝑎, 𝑏, 𝑐}, que acepte el lenguaje 𝐿 = {𝑥𝑐+*| 𝑥 ∈ {𝑎, 𝑏}∗ 𝑦 𝑙𝑎 𝑐𝑎𝑛𝑡𝑖𝑑𝑎𝑑 𝑑𝑒 𝑏,
𝑠 𝑒𝑠 𝑝𝑎𝑟 𝑦 𝑚 ≥ 0 }

Donde:

Σ = {a,b,c}  
Q = {start, s1, s2, s3, s4, s5}  
q₀ = start  
F = {start} 

Función de transición δ:

δ(start,a) = start  
δ(start,b) = s3 
δ(start,c) = s1    
δ(s1,a) = s1  
δ(s1,b) = s4  
δ(s1,c) = s  
δ(s2,a) = s5  
δ(s2,b) = s5  
δ(s2,c) = s3  
δ(s3,a) = s5  
δ(s3,b) = s5  
δ(s3,c) = s4  
δ(s4,a) = s5  
δ(s4,b) = s5  
δ(s4,c) = s2  
δ(s5,a) = s5  
δ(s5,b) = s5  
δ(s5,c) = s5  

*Tabla de trasnsición de estados*
| Estado  | a  | b  | c  |
| ------- | -- | -- | -- |
| → start | s0 | s1 | s2 |
| * s0    | s0 | s1 | s2 |
| s1      | s1 | s0 | s5 |
| s2      | s5 | s5 | s3 |
| s3      | s5 | s5 | s4 |
| * s4    | s5 | s5 | s2 |
| s5      | s5 | s5 | s5 |

<img width="1919" height="910" alt="Captura de pantalla 2026-03-03 200028" src="https://github.com/user-attachments/assets/aacbdb63-6ed7-4d6e-9012-cc5c226e9471" />
