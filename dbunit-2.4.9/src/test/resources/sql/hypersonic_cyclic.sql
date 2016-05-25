/**

 Creates tables to test DatabaseSequenceFilter's ordering algorithm with following cyclic dependencies:
 
	  A
	 / \
	D   |   
	 \ / 
	  C   
	 / \  
	E   B
	 \
	  A

*/

CREATE TABLE A
  (PKA NUMERIC,
   FKC NUMERIC,
   FKD NUMERIC,
   PRIMARY KEY (PKA));

CREATE TABLE B
  (PKB NUMERIC,
   PRIMARY KEY (PKB));

CREATE TABLE C
  (PKC NUMERIC,
   FKB NUMERIC,
   FKE NUMERIC,
   PRIMARY KEY (PKC));

CREATE TABLE D
  (PKD NUMERIC,
   FKC NUMERIC,
   PRIMARY KEY (PKD));

CREATE TABLE E
  (PKE NUMERIC,
   FKA NUMERIC,
   PRIMARY KEY (PKE));

ALTER TABLE A ADD CONSTRAINT AC FOREIGN KEY (FKC) REFERENCES C (PKC);
ALTER TABLE A ADD CONSTRAINT AD FOREIGN KEY (FKD) REFERENCES D (PKD);

ALTER TABLE C ADD CONSTRAINT CB FOREIGN KEY (FKB) REFERENCES B (PKB);
ALTER TABLE C ADD CONSTRAINT CE FOREIGN KEY (FKE) REFERENCES E (PKE);

ALTER TABLE D ADD CONSTRAINT DC FOREIGN KEY (FKC) REFERENCES C (PKC);

ALTER TABLE E ADD CONSTRAINT EA FOREIGN KEY (FKA) REFERENCES A (PKA);
