







# get pid
systemctl status clipboard@$(whoami).service

> pid: 3955



# kill process
sudo kill 3955



Status 1sec/sec siehe bild

![systemStaus After 1_6 sec.png](systemStaus%20After%201_6%20sec.png)



>get:
>
>
>  `#!/bin/bash`
>
>
> ``java ClipboardClient --get``

>put:
>
>
>  `#!/bin/bash`
>
>
> ``java ClipboardClient --store $1``
> 



### Ohne Sytemdiesnst : 
Ohne Sytemdiesnst wäre das ganze auch möglich indem mann ein 
get script und put script erstlt die beide auf eine datei
clipboardStorage.txt zugreiben das eine schreibt dass andere liest und so daten miteinander austauschen