.class public programa1
.super java/lang/Object
.field static data [I
.field static mx I
.field static mn I
.method public static det([I)V
.limit locals 5
.limit stack 5
iconst_0
istore 4

aload_3
arraylength
iconst_1
isub
istore 5

loop0:
iload 4
iload 5
if_icmpge loop0_end 
aload_3
iload 4
iaload
istore 6

iinc 4 1

aload_3
iload 4
iaload
istore 7

iload 6
iload 7
invokestatic library1/max(II)V
putstatic programa1/mx I 

iload 6
iload 7
invokestatic library1/min(II)V
putstatic programa1/mn I 

goto loop0
loop0_end:
return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 5
.limit stack 5
invokestatic programa1/det([I)V
ldc "max: "
iload_0
invokestatic io/println(Ljava/lang/String;I)V
ldc "min: "
iload_1
invokestatic io/println(Ljava/lang/String;I)V
return
.end method
.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method
