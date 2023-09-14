# HeyTrade Transfomer

La finalidad de este proyecto es transformar los PDFs de HeyTrade a Excel para poder después copiarlos más fácilmente al Excel Invertir.Capital.

## Uso

Copiar todos los pdfs tal y como los envía HeyTrade (mismo nombre) a la carpeta resources y ejecutar el main desde el IDE.

Creará el archivo heyTrade.xlsx con las hojas dividendos, Compra, Venta. Cada hoja la creará si hay operaciones de ese tipo.

La primera línea de las hojas son las cabeceras. Se incluye la siguiente información por hoja obtenida del PDF:
* **Dividendos**:  Identificación del instrumento	Descripción del instrumento	Divisa dividendo	Dividendo unitario	Fecha ex-date	Fecha de pago	Cantidad de acciones	Dividendo bruto	Retenciones en origen	Importe de retenciones en origen	Dividendo neto en origen	Tipo de cambio de divisa base	Tipo de cambio de divisa + comisión	Importe de comisión de cambio de divisa	Dividendo bruto en divisa de destino	Tipo de retención en destino	Importe de retención en destino	Gastos, comisiones e impuestos	Dividendo neto abonado
* **Compra**: Fecha y hora de ejecución	Identificación del instrumento	Descripción del instrumento	Centro de negociación	Cantidad	Precio unitario y divisa	Efectivo bruto	Impuestos	Subtotal	Tipo de cambio (incl. nuestra comisión)	Subtotal al cambio	Comisión de ejecución	Total en euros
* **Venta**: Fecha y hora de ejecución	Identificación del instrumento	Descripción del instrumento	Centro de negociación	Cantidad	Precio unitario y divisa	Efectivo bruto	Impuestos	Subtotal	Tipo de cambio (incl. nuestra comisión)	Subtotal al cambio	Comisión de ejecución	Total en euros

## Notas

IDE: IntelliJ Idea

Versión de Java: 17

En vez de heredar de PDFTextStripper, se podía recoger el texto del PDF en una cadena, que es lo que hace la instrucción pdfStripper.getText(pdDoc) y luego parsearlo.
Como internamente crea la lista, se me ocurrió aprovecharla.

Se distingue entre las diferentes operaciones según el campo Indicador de compra/venta o Indicador de operación que viene en el PDF.

Si HeyTrade cambia la estructura del PDF, deja de funcionar.

No hay control de nulos, excepciones, tests, mapeos bonitos, etc... Es un proyecto para solucionarme rápido un problema.
No se tuvo en cuenta la huella en memoria ni cpu. Tampoco la estructura está muy pensada. 
Por si no queda claro: NO ES PRODUCTIVO.
