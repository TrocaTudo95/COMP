.class public programa2
.super java/lang/Object
.method public static f1([I)[I
.limit locals 4
.limit stack 4
iconst_0
istore_2

aload_0
arraylength
istore_3

iload 4
aload 4

loop0:
iload_2
aload_0
arraylength
if_icmpge loop0_end 
aload 4
iload_2
aload_0
iload_2
iaload
iastore

iinc 2 1

goto loop0
loop0_end:
return
.end method
.method public static f2(I)[I
.limit locals 2
.limit stack 2
iload_1
aload_1

iconst_1
aload_1

return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 4
.limit stack 4
bipush 100
newarray int 
aload_1

aload_1
iconst_0
iconst_1
iastore

aload_1
bipush 99
iconst_2
iastore

invokestatic programa2/f1([I)[I
istore 6

aload 6
iconst_0
iaload
iload 6
istore 8

aload 6
bipush 99
iaload
iload 6
istore 10

ldc "first: "
iload 8
invokestatic io/println(Ljava/lang/String;I)V
ldc "last: "
iload 10
invokestatic io/println(Ljava/lang/String;I)V
bipush 100
invokestatic programa2/f2(I)[I
istore 6

aload 6
iconst_0
iaload
iload 6
istore 8

aload 6
bipush 99
iaload
iload 6
istore 10

ldc "first: "
iload 8
invokestatic io/println(Ljava/lang/String;I)V
ldc "last: "
iload 10
invokestatic io/println(Ljava/lang/String;I)V
return
.end method
.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method
