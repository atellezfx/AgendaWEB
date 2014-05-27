CREATE TABLE `CONTACTO` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `androidId` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `imageUri` varchar(255) DEFAULT NULL,
  `propietario` varchar(45) NOT NULL,
  `md5` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_contacto_nombre` (`nombre`),
  KEY `idx_contacto_propietario` (`propietario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
