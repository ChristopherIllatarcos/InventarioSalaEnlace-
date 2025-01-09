
CREATE TABLE `tb_accesorios_sala` (
  `idAccesorio` int NOT NULL AUTO_INCREMENT,
  `nombreAccesorio` varchar(45) NOT NULL,
  `cantidad` int NOT NULL,
  `estadoAccesorio` enum('Funcional','En Reparación','Obsoleto') NOT NULL,
  `fechaRegistro` date NOT NULL,
  `idSala` int NOT NULL,
  `observaciones` text,
  PRIMARY KEY (`idAccesorio`)

  CREATE TABLE `tb_inventario_computadores` (
  `idComputador` int NOT NULL AUTO_INCREMENT,
  `numeroEquipo` int NOT NULL,
  `Marca` varchar(50) NOT NULL,
  `Modelo` varchar(50) NOT NULL,
  `Procesador` varchar(50) NOT NULL,
  `RAM_GB` int NOT NULL,
  `Almacenamiento_GB` int NOT NULL,
  `Sistema_Operativo` varchar(50) NOT NULL,
  `Estado` enum('FUNCIONAL','EN_REPARACION','OBSOLETO') NOT NULL,
  `Ubicacion` varchar(100) NOT NULL,
  PRIMARY KEY (`idComputador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tb_usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `estado` int NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


