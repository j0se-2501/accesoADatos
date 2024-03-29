<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/compendio">
        <html>
            <head>
                <title>Libros</title>
                <style>
                    table {
                        border-collapse: collapse;
                        margin-left: auto;
                        margin-right: auto;
                    }

                    th, td {
                        border: 1px solid black;
                        padding: 8px;
                    }

                    th {
                        background-color: #f2f2f2;
                    }
                </style>
            </head>
            <body>
                <h1>Lista de Libros</h1>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Texto</th>
                    </tr>
                    <xsl:for-each select="libro">
                        <tr>
                            <td>
                                <xsl:value-of select="@id"/>
                            </td>
                            <td>
                                <xsl:value-of select="."/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
<xsl:output method="html"/>
</xsl:stylesheet>
