.class public programa2
.super java/lang/Object
.method public static f1([I)[I
.limit locals 5
.limit stack 5
iconst_0
istore_1

aload_arraylength
istore_2

iload_2
astore_1


aload_astore_1

iconst_1
iadd
istore_1

return
.end method
.method public static f2(I)[I
.limit locals 5
.limit stack 5
iload_2
istore_3

iconst_1
istore_3

return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 5
.limit stack 5
bitpush 100
newarray int 
astore_2

iconst_1
astore_2

iconst_2
astore_2

invokestatic programa2/f1([I)[I
istore_3

istore_4

istore 5

ldc "first: "
iload_3
invokestatic io/println([Ljava/lang/String;I)V
ldc "last: "
iload 4
invokestatic io/println([Ljava/lang/String;I)V
bitpush 100
invokestatic programa2/f2(I)[I
istore 3

istore 4

istore 5

ldc "first: "
iload_3
invokestatic io/println([Ljava/lang/String;I)V
ldc "last: "
iload 4
invokestatic io/println([Ljava/lang/String;I)V
return
.end method
.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method
