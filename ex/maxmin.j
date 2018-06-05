.class public maxmin
.super java/lang/Object
.method public static maxmin()I
.limit locals 1
.limit stack 1
iconst_-99
invokestatic io/read()V
istore_0

iload_0
iconst_0
if_icmpge loop0_end 
loop0:
iload_0
iconst_0
if_icmpge loop0_end 
iinc 0 1

goto loop0
loop0_end:
goto loop0_next
loop0_end:
loop1:
iload_0
iconst_0
if_icmple loop1_end 
iinc 0 -1

goto loop1
loop1_end:
loop0_next:
ldc "a"
iload_0
invokestatic io/println(Ljava/lang/String;I)V
return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 1
iconst_-99
invokestatic maxmin/maxmin()I
istore_0

ldc "a="
iload_0
invokestatic io/println(Ljava/lang/String;I)V
return
.end method
.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method
