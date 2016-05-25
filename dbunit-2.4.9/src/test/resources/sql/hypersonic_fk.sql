/**

 Creates tables use to test DatabaseSequenceFilter's ordering algorithm with following dependencies:
 
	  D
	 / \
	F   A   G
	 \ / \ /
	  C   E H
	   \ / /
	     B
	     
 The correct result should be: D, A, F, C, G, E, H, B

*/

CREATE TABLE A
  (PKA NUMERIC,
   FKD NUMERIC,
   PRIMARY KEY (PKA));

CREATE TABLE B
  (PKB NUMERIC,
   FKC NUMERIC,
   FKE NUMERIC,
   FKH NUMERIC,
   PRIMARY KEY (PKB));

CREATE TABLE C
  (PKC NUMERIC,
   FKA NUMERIC,
   FKF NUMERIC,
   PRIMARY KEY (PKC));

CREATE TABLE D
  (PKD NUMERIC,
   PRIMARY KEY (PKD));

CREATE TABLE E
  (PKE NUMERIC,
   FKA NUMERIC,
   FKG NUMERIC,
   PRIMARY KEY (PKE));

CREATE TABLE F
  (PKF NUMERIC,
   FKD NUMERIC,
   PRIMARY KEY (PKF));

CREATE TABLE G
  (PKG NUMERIC,
   PRIMARY KEY (PKG));

CREATE TABLE H
  (PKH NUMERIC,
   PRIMARY KEY (PKH));

ALTER TABLE A ADD CONSTRAINT AD FOREIGN KEY (FKD) REFERENCES D (PKD);

ALTER TABLE B ADD CONSTRAINT BC FOREIGN KEY (FKC) REFERENCES C (PKC);
ALTER TABLE B ADD CONSTRAINT BE FOREIGN KEY (FKE) REFERENCES E (PKE);
ALTER TABLE B ADD CONSTRAINT BH FOREIGN KEY (FKH) REFERENCES H (PKH);

ALTER TABLE C ADD CONSTRAINT CA FOREIGN KEY (FKA) REFERENCES A (PKA);
ALTER TABLE C ADD CONSTRAINT CF FOREIGN KEY (FKF) REFERENCES F (PKF);

ALTER TABLE E ADD CONSTRAINT EA FOREIGN KEY (FKA) REFERENCES A (PKA);
ALTER TABLE E ADD CONSTRAINT EG FOREIGN KEY (FKG) REFERENCES G (PKG);

ALTER TABLE F ADD CONSTRAINT FD FOREIGN KEY (FKD) REFERENCES D (PKD);