.class public programa1
.super java/lang/Object
.field static data [I
.field static mx I
.field static mn I
.method public static det([I)V
.limit locals 5
.limit stack 5
iconst_0
istore_1

aload_arraylength
iconst_1
isub
istore_2


aload_
iconst_1
iadd
istore_1

aload_
invokestatic library1/max()V

invokestatic library1/min()V

return
.end method
.method public static main([Ljava/lang/String;)V
.limit locals 5
.limit stack 5
invokestatic programa1/det([I)V
ldc "max: "
invokestatic io/println([Ljava/lang/String;)V
ldc "min: "
invokestatic io/println([Ljava/lang/String;)V
return
.end method
.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method
