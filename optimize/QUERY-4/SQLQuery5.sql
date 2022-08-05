

SET ANSI_PADDING ON

CREATE NONCLUSTERED INDEX [_dta_index_DS_TOUR_13_885578193__K3_K1_2] ON [dbo].[DS_TOUR]
(
	[GIA] ASC,
	[MA_TOUR] ASC
)
INCLUDE([TEN_TOUR]) WITH (SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF) ON [PRIMARY]
SET ANSI_PADDING ON

CREATE NONCLUSTERED INDEX [_dta_index_PHANCONG_13_1269579561__K1_K2] ON [dbo].[PHANCONG]
(
	[MANV] ASC,
	[MA_TOUR] ASC
)WITH (SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF) ON [PRIMARY]

SELECT DS.MA_TOUR, DS.TEN_TOUR, DS.GIA
FROM DS_TOUR DS, PHANCONG PC
WHERE DS.MA_TOUR LIKE '%SG%' AND DS.GIA >5000
		AND DS.MA_TOUR = PC.MA_TOUR AND PC.MANV = 'MNV01'