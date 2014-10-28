Option Explicit On
Option Strict On

Public Class Nif
    Dim numeroDni As Integer
    Dim letra As Char

    Function getLetra(ByVal dni As Integer) As Char
        Dim letras() As Char = {"T"c, "R"c, "W"c, "A"c, "G"c, "M"c, "Y"c, "F"c, "P"c, "D"c, "X"c, "B"c, "N"c, "J"c, "Z"c, "S"c, "Q"c, "V"c, "H"c, "L"c, "C"c, "K"c, "E"}
        Return letras(dni Mod 23)
    End Function

    Overloads Function toString(ByVal nif As Nif) As String
        Return numeroDni & "-" & letra
    End Function

End Class
